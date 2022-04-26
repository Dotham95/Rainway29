var addNew = false;
var username = "";
var password = "";
var accounts = [];
var currentPage = 1;
var size = 5;
var search = "";
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
  search = null;
  $(".main").load("crud.html", function () {
    // buildTableAccount();
    getDataAccount();
    getDepartment();
    getPosition();
  });
}

/******* LOGIN *********/
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
      getDepartment();
      getPosition();
      localStorage.setItem("username", username);
      localStorage.setItem("password", password);
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
});
/******* LOGIN *********/

/******* LOGOUT *********/
$(document).on("click", "#logout", function () {
  username = "";
  password = "";
  $(".header").empty();
  $(".main").empty();
  $(".header").load("login.html");
});
/******* LOGOUT *********/

/******* ONCLICK ADD *********/
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
    var id, email, username, fullName, departmentName, positionName, createDate;
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
      //todo
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
/******* ONCLICK ADD *********/

/******* ONCLICK DELETE *********/
$(document).on("click", ".delete", function () {
  var idDelete = $(this).parents("tr").find("#td-id").text();
  deleteAccount(idDelete, $(this).parents("tr"));
});

/******* GET DATA ACCOUNT  *********/
function getDataAccount(sortEmail, sortUser) {
  var url = "http://localhost:8080/v2/api/accounts";

  url += "?page=" + currentPage + "&size=" + size;
  if (sortEmail != undefined && sortEmail != "") {
    url += "&sort=email," + sortEmail;
  }
  if (sortUser != undefined && sortUser != "") {
    url += "&sort=username," + sortUser;
  }
  if (search) {
    url += "&userName=" + search;
  }
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      accounts = data.content;
      fillAccountToTable();
      pagingTableAccount(data.totalPages);
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}
/******* SORT ACCOUNT  *********/
var sort = "asc";
function sortAccountByEmail() {
  if (sort == "asc") {
    getDataAccount(sort);
    sort = "desc";
  } else {
    getDataAccount(sort);
    sort = "asc";
  }
}
function sortAccountByUsername() {
  if (sort == "asc") {
    getDataAccount("", sort);
    sort = "desc";
  } else {
    getDataAccount("", sort);
    sort = "asc";
  }
}
/******* FILL DATA ACCOUNT  *********/
function fillAccountToTable() {
  $("tbody").empty();
  $;
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
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="editAccount(this)">' +
        '<i class="material-icons">&#xE254;</i>' +
        "</a>" +
        '<a class="delete" title="Delete" data-toggle="tooltip"(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}
/******* ONCLICK EDIT *********/
function editAccount(buttonEdit) {
  var id, user_name, email, fullname, departmentName, positionName;
  $(buttonEdit)
    .parents("tr")
    .find("td:not(:last-child)")
    .each(function (index) {
      switch (index) {
        case 1:
          id = $(this).text();
          break;
        case 2:
          email = $(this).text();
          break;
        case 3:
          user_name = $(this).text();
          break;
        case 4:
          fullname = $(this).text();
          break;
        case 5:
          departmentName = $(this).text();
          break;
        case 6:
          positionName = $(this).text();
          break;
      }
    });

  updateAccount(id, email, user_name, fullname, departmentName, positionName);
}
/******* ONCLICK EDIT *********/
/******* PAGING ACCOUNT *********/
function pagingTableAccount(pageAmount) {
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
  buildTableAccount();
}

/******* PAGING  *********/
/******* BUILD DATA  *********/
function buildTableAccount() {
  $("tbody").empty();
  getDataAccount();
}
/******* GET DEPARTMENT  *********/
function getDepartment() {
  $.ajax({
    url: "http://localhost:8080/v2/api/departments?size=20",
    type: "GET",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      arrayDepartment = result.content;
      fillDerpartmentToTable(arrayDepartment);
    },
    error: function (data, status) {
      console.log("status = " + status + "  " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}
function fillDerpartmentToTable(arrayDp) {
  $("#departmentSelect").empty();
  var text = "";
  arrayDp.forEach((element) => {
    text += `<option value="${element.id}">${element.name}</option>`;
  });
  $("#departmentSelect").html(text);
}
/******* GET POSITION  *********/
function getPosition() {
  $.ajax({
    url: "http://localhost:8080/v2/api/positions",
    type: "GET",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      arrayPosition = result.content;
      fillPositionToTable(arrayPosition);
    },
    error: function (data, status) {
      console.log("status = " + status + "  " + JSON.stringify(data));
      alert(data.responseJSON.message);
    },
  });
}

function fillPositionToTable(arrayPo) {
  $("#positionSelect").empty();
  var text = "";
  arrayPo.forEach((element) => {
    text += `<option value="${element.id}">${element.name}</option>`;
  });
  $("#positionSelect").html(text);
}

/******* AND NEW  *********/
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
  document.getElementById("roleSelect").value = "1";
  document.getElementById("roleSelect").style.display = "block";
  document.getElementById("labelRole").style.display = "block";
  document.getElementById("departmentSelect").value = "1";
  document.getElementById("positionSelect").value = "1";
  var button = document.getElementById("saveAccount");
  button.innerHTML = "Save";
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

/******* DELETE ACCOUNT  *********/
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
      resetTable();
      buildTableAccount();
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
      resetTable();
      buildTableAccount();
    },
  });
}
/******* DELETE ACCOUNT *********/

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
        hideModal();
        resetTable();
        buildTableAccount();
      }
    },
    error: function (data, status, xhr) {
      console.log(JSON.stringify(data));
      console.log(status + " <==>" + JSON.stringify(xhr));
      console.log(data);
      alert("Create thất bại : " + JSON.stringify(data.responseJSON.message));
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

  var roleSl = document.getElementById("roleSelect");
  var role = roleSl.options[roleSl.selectedIndex].value;

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
  document.getElementById("titleModal").innerHTML = "Update Account";
  document.getElementById("username").value = user_name;
  document.getElementById("fullname").value = fullname;
  document.getElementById("email").value = email;
  document.getElementById("roleSelect").style.display = "none";
  document.getElementById("labelRole").style.display = "none";
  var button = document.getElementById("saveAccount");
  button.innerHTML = "Update";
  button.onclick = function () {
    updateAccountSubmit(id);
  };
  $("#departmentSelect option").each(function () {
    var t = $(this).text();
    if (departmentName.toLowerCase().trim() == t.toLowerCase().trim()) {
      $(this).prop("selected", true);
      return false;
    }
  });
  $("#positionSelect option").each(function () {
    var s = $(this).text();
    if (positionName.toLowerCase().trim() == s.toLowerCase().trim()) {
      $(this).prop("selected", true);
      return false;
    }
  });
  openModal();
}

function updateAccountSubmit(id) {
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
        hideModal();
        resetTable();
        buildTableAccount();
      }
    },
    error: function (data, status) {
      alert("Update không thành công");
    },
  });
}
function resetFormUpdate() {
  document.getElementById("titleModal").innerHTML = "Update Account";
  document.getElementById("email").value = "";
  document.getElementById("username").value = "";
  document.getElementById("fullname").value = "";
  document.getElementById("roleSelect").value = "";
  document.getElementById("roleSelect").style.display = "none";
  document.getElementById("labelRole").style.display = "none";
}
/******* UPDATE ACCOUNT  *********/

/******* SEARCH  *********/
function Search() {
  var s = document.getElementById("input-search-account").value;
  if (search != s) {
    search = s;
    resetPaging();
    resetCheckBoxAll();
    buildTableAccount();
  }
}

function resetTable() {
  resetPaging();
  resetSearch();
  resetCheckBoxAll();
}

function resetSearch() {
  document.getElementById("input-search-account").value = "";
}
/******* SEARCH  *********/
