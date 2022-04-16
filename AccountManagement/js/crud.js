var addNew = false;
var username = "";
var password = "";
var accounts = [];
var currentPage = 1;
var size = 5;
var arrayDepartment = [];
var arrayPosition = [];

$(function () {
  $(".header").load("header.html");
  $(".main").load("home.html");
  $(".footer").load("footer.html");
});

function clickNavHome() {
  $(".main").load("home.html");
}

function clickNavViewListAccounts() {
  $(".main").load("crud.html", function () {
    buildTable();
  });
}
function clickNavlogout() {
  $(".main").load("home.html");
}
function login() {
  username = $("#username").val();
  password = $("#password").val();
  var url = "http://localhost:8080/v2/api/accounts/login";

  url += "?username=" + username + "&password=" + password;
  $.ajax({
    url: url,
    type: "GET",
    success: function (result) {
      $(".header").load("header.html");
    },
    error: function (data, status) {
      console.log("status =" + status + " " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}
$(document).ready(function () {
  $(".header").load("login.html");

  $('[data-toggle="tooltip"]').tooltip();
  var actions = $("table td:last-child").html();

  $(document).on("click", ".add", function () {
    var empty = false;
    var input = $(this).parents("tr").find('input[type="text"]');
    input.each(function () {
      if (!$(this).val()) {
        $(this).addClass("error");
        empty = true;
      } else {
        $(this).removeClass("error");
      }
    });
    $(this).parents("tr").find(".error").first().focus();

    if (!empty) {
      var id,
        email,
        username,
        fullName,
        departmentName,
        positionName,
        createDate;
      input.each(function (index) {
        let value = $(this).val();
        $(this).parent("td").html(value);
        switch (index) {
          case 0: {
            id = value;
            break;
          }
          case 1: {
            email = value;
            break;
          }
          case 2: {
            username = value;
            break;
          }
          case 3: {
            fullName = value;
            break;
          }
          case 4: {
            departmentName = value;
            break;
          }
          case 5: {
            positionName = value;
            break;
          }
          case 6: {
            createDate = value;
            break;
          }
        }
        index++;
      });
      if (addNew == false) {
        updateAccount(
          id,
          email,
          username,
          fullName,
          departmentName,
          positionName,
          role,
          createDate
        );
      } else {
        addNew = false;
        createAccount(
          id,
          email,
          username,
          fullName,
          departmentName,
          positionName,
          role,
          createDate
        );
      }
      $(this).parents("tr").find(".add, .edit").toggle();
      $(".add-new").removeAttr("disabled");
    }
  });

  $(document).on("click", ".edit", function () {
    $(".add-new").attr("disabled", "disabled");
  });

  $(document).on("click", ".delete", function () {
    var idDelete = $(this).parents("tr").find("#td-id").text();
    deleteAccount(idDelete, $(this).parents("tr"));
  });
});

/******* GET DATA  *********/
function getData() {
  var url = "http://localhost:8080/v2/api/accounts";

  url += "?page=" + currentPage + "&size=" + size;
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      accounts = data.content;
      fillAccountToTable();
      pagingTable(data.totalPages);
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}
/******* GET DATA  *********/
function pagingTable(pageAmount) {
  var pagingStr = "";

  if (pageAmount > 1 && currentPage > 1) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="prevPaging()">Previous</a>' +
      "</li>";
  }

  for (i = 0; i < pageAmount; i++) {
    pagingStr +=
      '<li class="page-item ' +
      (currentPage == i + 1 ? "active" : "") +
      '">' +
      '<a class="page-link" onClick="changePage(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }

  if (pageAmount > 1 && currentPage < pageAmount) {
    pagingStr +=
      '<li class="page-item">' +
      '<a class="page-link" onClick="nextPaging()">Next</a>' +
      "</li>";
  }

  $("#pagination").empty();
  $("#pagination").append(pagingStr);
}
function onClickSearchButton() {
  resetPaging();
  buildTable();
}

function resetSearch() {
  document.getElementById("searchInput").value = "";
}

function resetPaging() {
  currentPage = 1;
  size = 5;
}

function prevPaging() {
  changePage(currentPage - 1);
  resetCheckBoxAll();
}

function nextPaging() {
  changePage(currentPage + 1);
  resetCheckBoxAll();
}

function changePage(page) {
  if (page == currentPage) {
    return;
  }
  resetCheckBoxAll();
  currentPage = page;
  buildTable();
}

function getDepartment() {}
function getPosition() {}

function fillAccountToTable() {
  $("tbody").empty();
  accounts.forEach(function (item, index) {
    $("tbody").append(
      "<tr>" +
        '<td><input id="checkbox-' +
        index +
        '"' +
        `type="checkbox" onClick="onChangeCheckboxItem(this ,${item.id})"></td>` +
        '<td id="td-id" style = "display:none">' +
        item.id +
        "</td>" +
        "<td>" +
        item.email +
        "</td>" +
        "<td>" +
        item.username +
        "</td>" +
        "<td>" +
        item.fullName +
        "</td>" +
        "<td>" +
        item.departmentName +
        "</td>" +
        "<td>" +
        item.positionName +
        "</td>" +
        "<td>" +
        item.createDate +
        "</td>" +
        "<td>" +
        '<a class="add" title="Add" data-toggle="tooltip" onclick="openUpdateModal(' +
        item.id +
        ')"><i class="material-icons">&#xE03B;</i></a>' +
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
        item.id +
        ')"><i class="material-icons">&#xE254;</i></a>' +
        '<a class="delete" title="Delete" data-toggle="tooltip"(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}

function buildTable() {
  $("tbody").empty();
  getData();
}
function openAddModal() {
  openModal();
  resetFormAdd();
}

function resetFormAdd() {
  document.getElementById("titleModal").innerHTML = "Add Account";
  document.getElementById("id").value = "";
  document.getElementById("email").value = "";
  document.getElementById("username").value = "";
  document.getElementById("fullname").value = "";
  document.getElementById("role").value = "";
  document.getElementById("role").style.display = "block";
  document.getElementById("labelRole").style.display = "block";
  var button = document.getElementById("saveAccount");
  button.innerHTML = "save";
  button.onclick = function () {
    save();
  };
}
function openModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
}

/******* DELETE  *********/
function deleteAccount(id, elementTr) {
  console.log("id = " + id);
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
      elementTr.remove();
      alert("Delete thành công");
      resetPaging();
      buildTable();
    },
    error: function (data, status) {
      if (data.status == 403) {
        alert("Tài khoản không có quyền xoá");
      }
    },
  });
}

// Xử lý sự kiện xoá nhiều checkbox
var listIdDelette = [];
function onChangeCheckboxItem(checkbox, id) {
  var value = checkbox.checked;
  if (value == true) {
    listIdDelette.push(id);
  } else {
    listIdDelette = listIdDelette.filter((item) => item != id);
  }
}

function resetCheckBoxAll() {
  document.getElementById("checkbox-all").checked = false;
  listIdDelette = [];
}

function onChangeCheckboxAll() {
  listIdDelette = [];
  var value = document.getElementById("checkbox-all").checked;
  console.log("CheckAll +" + value);
  // tạo mảng id xoá
  if (value) {
    accounts.forEach((element) => {
      listIdDelette.push(element.id);
    });
  }
  for (let i = 0; ; i++) {
    var checkboxItem = document.getElementById("checkbox-" + i);
    if (checkboxItem !== undefined && checkboxItem !== null) {
      checkboxItem.checked = value;
    } else {
      break;
    }
  }
}

function deleteAllAccount() {
  if (listIdDelette.length == 0) {
    return;
  }

  $.ajax({
    url: "http://localhost:8080/v2/api/accounts?ids=" + listIdDelette,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
      alert("Delete  Accouts + " + JSON.stringify(listIdDelette));
      resetCheckBoxAll();
      resetPaging();
      buildTable();
    },
  });
}
/******* DELETE  *********/

/******* CREATE ACCOUNT  *********/

function createAccount(
  email,
  user_name,
  fullName,
  departmentId,
  positionId,
  role
) {
  console.log(
    `new data =  ${email}, ${user_name}, ${fullName}, ${departmentId}, ${positionId}, ${role}`
  );
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts",
    type: "POST",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"email":"${email}","username":"${user_name}","fullName":"${fullName}", "departmentId" :"${departmentId}", "positionId":"${positionId}","role":"${role}"}`,
    success: function (listData, status, xhr) {
      if (status == "success") {
        alert("Create thành công");
        getData();
        hideModal();
      }
    },
    error: function (data, status, xhr) {
      console.log(JSON.stringify(data));
      console.log(status + " <==>" + JSON.stringify(xhr));
      alert("Create thất bại : " + JSON.stringify(data));
    },
  });
}
function save() {
  var username = document.getElementById("username").value;
  var email = document.getElementById("email").value;
  var fullname = document.getElementById("fullname").value;

  var selectorDepartment = document.getElementById("departmentSelect");
  var departmentID =
    selectorDepartment.options[selectorDepartment.selectedIndex].value;

  var positionSl = document.getElementById("positionSelect");
  var positionID = positionSl.options[positionSl.selectedIndex].value;

  var role = document.getElementById("role").value;

  createAccount(email, username, fullname, departmentID, positionID, role);
}
/******* CREATE ACCOUNT  *********/

/******* UPDATE ACCOUNT  *********/

function updateAccount(
  id,
  email,
  user_name,
  fullname,
  departmentName,
  positionName
) {
  document.getElementById("id").value = id;
  document.getElementById("username").value = user_name;
  document.getElementById("fullname").value = fullname;
  document.getElementById("email").value = email;
  var dpSelect = document.getElementsById("departmentSelect");
  console.log(JSON.stringify(dpSelect.options));
  for (let i = 0; dpSelect.options.length; i++) {
    if (dpSelect.options[i] != undefined) {
      let v = dpSelect.options[i].value;
      if (v == departmentName) {
        dpSelect.options[i].selected = true;
      }
    }
  }

  var poSelect = document.getElementsById("positionSelect");
  for (let i = 0; poSelect.options.length; i++) {
    if (poSelect.options[i] != undefined) {
      let v = poSelect.options[i].value;
      if (v == positionName) {
        poSelect.options[i].selected = true;
      }
    }
  }

  openModal();
}

function openUpdateModal(id) {
  resetFormUpdate();
  $(".add-new").attr("disabled", "disabled");
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      openModal();

      document.getElementById("titleModal").innerHTML = "Update Account";
      document.getElementById("username").value = data.username;
      document.getElementById("fullname").value = data.fullName;
      document.getElementById("email").value = data.email;

      $("#departmentSelect option").each(function () {
        var t = $(this).text();
        if (
          t.toLowerCase().trim() == data.departmentName.toLowerCase().trim()
        ) {
          $(this).prop("selected", true);
          return false;
        }
      });

      $.each($("#positionSelect option"), function () {
        var t = $(this).text();
        if (t.toLowerCase().trim() == data.positionName.toLowerCase().trim()) {
          $(this).prop("selected", true);
          return false;
        }
      });

      var button = document.getElementById("saveAccount");
      button.innerHTML = "Update";
      button.onclick = function () {
        updateAccount(id);
      };
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}
function updateAccount(id) {
  var user_name = document.getElementById("username").value;
  var fullname = document.getElementById("fullname").value;
  var email = document.getElementById("email").value;
  var selectorDepartment = document.getElementById("departmentSelect");
  var departmentID =
    selectorDepartment.options[selectorDepartment.selectedIndex].value;

  var positionSl = document.getElementById("positionSelect");
  var positionID = positionSl.options[positionSl.selectedIndex].value;

  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "PUT",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"email":"${email}","username":"${user_name}","fullName":"${fullname}", "departmentId" :"${departmentID}", "positionId":"${positionID}"}`,
    success: function (listData, status, xhr) {
      if (status == "success") {
        alert("Update thành công");
        getData();
        hideModal();
      }
    },
    error: function (data, status) {
      alert("Update không thành công");
    },
  });
  $(".add-new").removeAttr("disabled");
}
function resetFormUpdate() {
  document.getElementById("titleModal").innerHTML = "Update Account";
  document.getElementById("email").value = "";
  document.getElementById("username").value = "";
  document.getElementById("fullname").value = "";
  document.getElementById("role").value = "";
  document.getElementById("role").style.display = "none";
  document.getElementById("labelRole").style.display = "none";
}
/******* UPDATE ACCOUNT  *********/
