var addNew = false;

$(document).ready(function () {
  $(".content-body").load("crud.html");

  getData();

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
      var index = 1;
      input.each(function () {
        let value = $(this).val();
        $(this).parent("td").html(value);
        switch (index) {
          case 1: {
            id = value;
            break;
          }
          case 2: {
            email = value;
            break;
          }
          case 3: {
            username = value;
            break;
          }
          case 4: {
            fullName = value;
            break;
          }
          case 5: {
            departmentName = value;
            break;
          }
          case 6: {
            positionName = value;
            break;
          }
          case 7: {
            createDate = value;
            break;
          }
        }
        index++;
      });

      console.log(
        `email : ${email}, username : ${username}, fullName: ${fullName}, departmentName :${departmentName}, positionName:${positionName}, createDate : ${createDate}`
      );
      if (addNew == false) {
        updateAccount(
          id,
          email,
          username,
          fullName,
          departmentName,
          positionName,
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
          createDate
        );
      }
      $(this).parents("tr").find(".add, .edit").toggle();
      $(".add-new").removeAttr("disabled");
    }
  });

  // Edit row on edit button click
  $(document).on("click", ".edit", function () {
    $(this)
      .parents("tr")
      .find("td:not(:last-child)")
      .each(function () {
        $(this).html(
          '<input type="text" class="form-control" value="' +
            $(this).text() +
            '">'
        );
      });
    $(this).parents("tr").find(".add, .edit").toggle();
    $(".add-new").attr("disabled", "disabled");
  });
  // Delete row on delete button click
  $(document).on("click", ".delete", function () {
    var idDelete = $(this).parents("tr").find("#td-id").text();
    deleteAccount(idDelete, $(this).parents("tr"));
  });
});
var accounts = [];
var currentPage = 1;
var size = 5;
function getData() {
  var url = "http://localhost:8080/v2/api/accounts";

  url += "?page=" + currentPage + "&size=" + size;

  $.get(url, function (data, status) {
    accounts = [];

    if (status == "error") {
      alert("Error when loading data");
      return;
    }
    accounts = data.content;
    fillAccountToTable();
    // resetDeleteCheckbox();
    pagingTable(data.totalPages);
  });
}
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
// function resetDeleteCheckbox() {

//   document.getElementById("checkbox-all").checked = false;

//   var i = 0;
//   while (true) {
//       var checkboxItem = document.getElementById("checkbox-" + i);
//       if (checkboxItem !== undefined && checkboxItem !== null) {
//           checkboxItem.checked = false;
//           i++;
//       } else {
//           break;
//       }
//   }
// }
function fillAccountToTable() {
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
        '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
        item.id +
        ')"><i class="material-icons">&#xE254;</i></a>' +
        '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
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
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      elementTr.remove();
      alert("Delete thanh cong");
      resetPaging();
      buildTable();
    },
  });
}

// su ly su kien xoa nhieu checkbox
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
  // tao mang id xoa
  if (value) {
    accounts.forEach((element) => {
      listIdDelette.push(element.id);
    });
  }
  // check all item
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

function updateAccount(
  id,
  email,
  username,
  fullName,
  departmentName,
  positionName,
  createDate
) {
  console.log(
    `new data = ${id} , ${email}, ${username}, ${fullName}, ${departmentName}, ${positionName}, ${createDate}`
  );
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts/" + id,
    type: "PUT",
    contentType: "application/json",
    data: `{"email":"${email}","username":"${username}","fullName":"${fullName}", "departmentName" :"${departmentName}", "positionName":"${positionName}", "createDate": "${createDate}"}`,
    success: function (listData, status, xhr) {
      console.log("Update thành công");
    },
  });
}

/******* CREATE ACCOUNT  *********/

function createAccount(email, username, fullName, departmentId, positionId) {
  console.log(
    `new data =  ${email}, ${username}, ${fullName}, ${departmentId}, ${positionId}`
  );
  $.ajax({
    url: "http://localhost:8080/v2/api/accounts",
    type: "POST",
    contentType: "application/json",
    data: `{"email":"${email}","username":"${username}","fullName":"${fullName}", "departmentId" :"${departmentId}", "positionId":"${positionId}"}`,
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
      alert("Create that bai: " + JSON.stringify(data));
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

  createAccount(email, username, fullname, departmentID, positionID);
}
/******* CREATE ACCOUNT  *********/
function addAccount() {
  // get data
  var username = document.getElementById("username").value;

  // validate name 6 -> 30 characters
  if (!username || username.length < 6 || username.length > 30) {
    // show error message
    showNameErrorMessage("Account name must be from 6 to 30 characters!");
    return;
  }

  // validate unique name
  $.get(
    "http://localhost:8080/v2/api/accounts/" + username + "/exists",
    function (data, status) {
      // error
      if (status == "error") {
        // TODO
        alert("Error when loading data");
        return;
      }

      if (data) {
        // show error message
        showNameErrorMessage("Account username is exists!");
      } else {
        // call api create department
        var account = {};

        $.ajax({
          url: "http://localhost:8080/v2/api/accounts",
          type: "POST",
          data: JSON.stringify(account), // body
          contentType: "application/json", // type of body (json, xml, text)
          // dataType: 'json', // datatype return
          success: function (data, textStatus, xhr) {
            console.log(data);
            // success
            hideModal();
            showSuccessAlert();
            buildTable();
          },
          error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
          },
        });
      }
    }
  );
}
function resetFormUpdate() {
  document.getElementById("titleModal").innerHTML = "Update Account";
  document.getElementById("authorLabel").style.display = "block";
  document.getElementById("author").style.display = "block";
  document.getElementById("createdDateLabel").style.display = "block";
  document.getElementById("createdDate").style.display = "block";
  hideNameErrorMessage();
}
var oldName;

function openUpdateModal(id) {
  $.get("http://localhost:8080/v2/api/accounts/" + id, function (data, status) {
    // error
    if (status == "error") {
      // TODO
      alert("Error when loading data");
      return;
    }

    // success
    openModal();
    resetFormUpdate();

    oldName = data.name;

    // fill data
    document.getElementById("id").value = data.id;
    document.getElementById("email").value = data.email;
    document.getElementById("username").value = data.username;
    document.getElementById("fullName").value = data.fullName;
    document.getElementById("departmentName").value = data.departmentName;
    document.getElementById("positionName").value = data.positionName;
    document.getElementById("createDate").value = data.createDate;
  });
}

/*
function createTable(listData) {
  console.log(JSON.stringify(listData));
  var tBodyData = "";

  listData.forEach((element) => {
    let dpName = element.departmentName != null ? element.departmentName : null;

    let poName = element.positionName != null ? element.positionName : null;
    tBodyData += "<tr>";
    tBodyData += `<td id="td-id" style = "display:none">${element.id}</td>`;
    tBodyData += `<td>${element.email}</td>`;
    tBodyData += `<td>${element.username}</td>`;
    tBodyData += `<td>${element.fullName}</td>`;
    tBodyData += `<td>${dpName}</td>`;
    tBodyData += `<td>${poName}</td>`;
    tBodyData += `<td>${element.createDate}</td>`;
    tBodyData += `<td>
      <a class="add" title="Add" data-toggle="tooltip">
        <i class="material-icons">&#xE03B;</i>
      </a>
      <a class="edit" title="Edit" data-toggle="tooltip">
        <i class="material-icons">&#xE254;</i>
      </a>
      <a class="delete" title="Delete" data-toggle="tooltip">
        <i class="material-icons">&#xE872;</i></a>
      </td>`;
    tBodyData += "</tr>";
  });

  $("tbody").html(tBodyData);
}*/

function ClickAdd() {
  console.log("click buttonAdd");
  addNew = true;
  $(this).attr("disabled", "disabled");
  var index = $("table tbody tr:last-child").index();
  var row =
    "<tr>" +
    '<td style ="display: none"><input type="text" class="form-control" value="1"></td>' +
    '<td><input type="text" class="form-control" name="email" id="email"></td>' +
    '<td><input type="text" class="form-control" name="userName" id="username"></td>' +
    '<td><input type="text" class="form-control" name="fullName" id="fullName"></td>' +
    '<td><input type="text" class="form-control" name="departmentName" id="departmentName"></td>' +
    '<td><input type="text" class="form-control" name="positionName" id="positionName"></td>' +
    `<td>
              <a class="add" title="Add" data-toggle="tooltip">
                <i class="material-icons">&#xE03B;</i>
              </a>
              <a class="edit" title="Edit" data-toggle="tooltip">
                <i class="material-icons">&#xE254;</i>
              </a>
              <a class="delete" title="Delete" data-toggle="tooltip">
                <i class="material-icons">&#xE872;</i></a>
              </td>` +
    "</tr>";
  $("table").append(row);
  $("table tbody tr")
    .eq(index + 1)
    .find(".add, .edit")
    .toggle();
  //$('[data-toggle="tooltip"]').tooltip();
}
