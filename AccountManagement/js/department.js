var addNewD = false;
var departments = [];
var currentPageD = 1;
var sizeD = 5;
var searchD = "";
function clickNavViewListDepartments() {
  searchD = null;
  $(".main").load("department.html", function () {
    buildTableDepartment();
  });
}
/******* ONCLICK ADD *********/
$(document).on("click", ".add-D", function () {
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
    var id, departmentName, type, createDate;
    input.each(function (index) {
      let value = $(this).val();
      $(this).parent("td").html(value);
      switch (index) {
        case 0: {
          id = value;
          break;
        }
        case 1: {
          departmentName = value;
          break;
        }
        case 2: {
          type = value;
          break;
        }
        case 3: {
          createDate = value;
          break;
        }
      }
      index++;
    });
    if (addNewD == false) {
      updateDepartment(id, departmentName, type);
    } else {
      addNewD = false;
      createDepartment(id, departmentName, type, createDate);
    }
    $(this).parents("tr").find(".add-D, .editD").toggle();
    $(".add-new-department").removeAttr("disabled");
  }
});
/******* ONCLICK ADD *********/

/******* ONCLICK DELETE *********/
$(document).on("click", ".deleteD", function () {
  var idDelete = $(this).parents("tr").find("#td-id").text();
  deleteDepartment(idDelete, $(this).parents("tr"));
});

/******* GET DATA DEPARTMENT  *********/
function getDataDepartment(sortName, sortType) {
  var url = "http://localhost:8080/v2/api/departments";

  url += "?page=" + currentPageD + "&size=" + sizeD;
  if (sortName != undefined && sortName != "") {
    url += "&sort=name," + sortName;
  }
  if (sortType != undefined && sortType != "") {
    url += "&sort=type," + sortType;
  }
  if (searchD) {
    url += "&type=" + searchD;
  }
  $.ajax({
    url: url,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      departments = data.content;
      fillDepartment();
      pagingTableDepartment(data.totalPages);
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}

/******* SORT ACCOUNT  *********/
var sort = "asc";
function sortDepartmentName() {
  if (sort == "asc") {
    getDataDepartment(sort);
    sort = "desc";
  } else {
    getDataDepartment(sort);
    sort = "asc";
  }
}
function sortDepartmentType() {
  if (sort == "asc") {
    getDataDepartment("", sort);
    sort = "desc";
  } else {
    getDataDepartment("", sort);
    sort = "asc";
  }
}

/******* FILL DATA DEPARTMENT  *********/
function fillDepartment() {
  $("tbody").empty();
  $;
  departments.forEach(function (item, index) {
    $("tbody").append(
      "<tr>" +
        '<td><input id="checkboxD-' +
        index +
        '"' +
        `type="checkbox" onClick="onChangeCheckboxItemDepartment(this ,${item.id})"></td>` +
        '<td id="td-id" style = "display:none">' +
        item.id +
        "</td>" +
        "<td>" +
        item.name +
        "</td>" +
        "<td>" +
        item.type +
        "</td>" +
        "<td>" +
        item.createDate +
        "</td>" +
        "<td>" +
        '<a class="editD" title="Edit" data-toggle="tooltip"  onclick="openUpdateModal(' +
        item.id +
        ')"><i class="material-icons">&#xE254;</i>' +
        "</a>" +
        '<a class="deleteD" title="Delete" data-toggle="tooltip"(' +
        item.id +
        ')"><i class="material-icons">&#xE872;</i></a>' +
        "</td>" +
        "</tr>"
    );
  });
}

/******* ONCLICK EDIT *********/
function editDepartment(buttonEditD) {
  var id, departmentName, type;
  $(buttonEditD)
    .parents("tr")
    .find("td:not(:last-child)")
    .each(function (index) {
      switch (index) {
        case 1:
          id = $(this).text();
          break;
        case 2:
          departmentName = $(this).text();
          break;
        case 3:
          type = $(this).text();
          break;
      }
    });

  openUpdateModal();
}

/******* ONCLICK EDIT *********/

/******* PAGING DEPARTMENT *********/
function pagingTableDepartment(pageAmountD) {
  var pagingStrD = "";

  if (pageAmountD > 1 && currentPageD > 1) {
    pagingStrD +=
      '<li class="page-item-d">' +
      '<a class="page-link-d" onClick="prevPagingD()">Previous</a>' +
      "</li>";
  }

  for (i = 0; i < pageAmountD; i++) {
    pagingStrD +=
      '<li class="page-item-d ' +
      (currentPageD == i + 1 ? "active" : "") +
      '">' +
      '<a class="page-link-d" onClick="changePageD(' +
      (i + 1) +
      ')">' +
      (i + 1) +
      "</a>" +
      "</li>";
  }

  if (pageAmountD > 1 && currentPageD < pageAmountD) {
    pagingStrD +=
      '<li class="page-item-d">' +
      '<a class="page-link-d" onClick="nextPagingD()">Next</a>' +
      "</li>";
  }

  $("#pagination").empty();
  $("#pagination").append(pagingStrD);
}

function resetPagingD() {
  currentPageD = 1;
  sizeD = 5;
}

function prevPagingD() {
  changePageD(currentPageD - 1);
  resetCheckBoxAllDepartment;
}

function nextPagingD() {
  changePageD(currentPageD + 1);
  resetCheckBoxAllDepartment;
}

function changePageD(pageD) {
  if (pageD == currentPageD) {
    return;
  }
  currentPageD = pageD;
  buildTableDepartment();
}
/******* PAGING DEPARTMENT *********/

/******* BUILD DATA  *********/
function buildTableDepartment() {
  $("tbody").empty();
  getDataDepartment();
}

/******* AND NEW  *********/
function openAddModalDepartment() {
  openModalDepartment();
  resetFormAddDepartment();
}
function resetFormAddDepartment() {
  document.getElementById("titleModalDepartment").innerHTML = "Add Department";
  document.getElementById("id").value = "";
  document.getElementById("departmentName").value = "";
  document.getElementById("type").value = "";
  var button = document.getElementById("saveDepartment");
  button.innerHTML = "Save";
  button.onclick = function () {
    saveDepartment();
  };
}
function openModalDepartment() {
  $("#myModalDepartment").modal("show");
}

function hideModalDepartment() {
  $("#myModalDepartment").modal("hide");
}
/******* DELETE DEPARTMENT *********/
function deleteDepartment(id, elementTr) {
  $.ajax({
    url: "http://localhost:8080/v2/api/departments/" + id,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
      elementTr.remove();
      alert("Delete thành công");
      resetTableDepartment();
      buildTableDepartment();
    },
    error: function (data, status) {
      if (data.status == 403) {
        alert("Tài khoản không có quyền xoá");
      }
    },
  });
}

// Xử lý sự kiện xoá nhiều checkbox
var listIdDeletteDepartment = [];
function onChangeCheckboxItemDepartment(checkbox, id) {
  var valueD = checkbox.checked;
  if (valueD == true) {
    listIdDeletteDepartment.push(id);
  } else {
    listIdDeletteDepartment = listIdDeletteDepartment.filter(
      (item) => item != id
    );
  }
}

function resetCheckBoxAllDepartment() {
  document.getElementById("checkbox-all-department").checked = false;
  listIdDeletteDepartment = [];
}

function onChangeCheckboxAllDepartment() {
  listIdDeletteDepartment = [];
  var valueD = document.getElementById("checkbox-all-department").checked;
  // tạo mảng id xoá
  if (valueD) {
    departments.forEach((element) => {
      listIdDeletteDepartment.push(element.id);
    });
  }
  for (let i = 0; ; i++) {
    var checkboxItemDepartment = document.getElementById("checkboxD-" + i);
    if (
      checkboxItemDepartment !== undefined &&
      checkboxItemDepartment !== null
    ) {
      checkboxItemDepartment.checked = value;
    } else {
      break;
    }
  }
}

function deleteAllDepartment() {
  if (listIdDeletteDepartment.length == 0) {
    return;
  }

  $.ajax({
    url:
      "http://localhost:8080/v2/api/departments?ids=" + listIdDeletteDepartment,
    type: "DELETE",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
      alert("Delete  Departments + " + JSON.stringify(listIdDeletteDepartment));
      resetTableDepartment();
      buildTableDepartment();
    },
  });
}
/******* DELETE DEPARTMENT *********/

/******* CREATE DEPARTMENT  *********/
function createDepartment(departmentName, type) {
  $.ajax({
    url: "http://localhost:8080/v2/api/departments",
    type: "POST",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"name":"${departmentName}","type":"${type}"}`,
    success: function (listData, status, xhr) {
      if (status == "success") {
        alert("Create thành công");
        hideModalDepartment();
        resetTableDepartment();
        buildTableDepartment();
      }
    },
    error: function (data, status, xhr) {
      console.log(JSON.stringify(data));
      console.log(status + " <==>" + JSON.stringify(xhr));
      alert("Create thất bại : " + JSON.stringify(data));
    },
  });
}
function saveDepartment() {
  var departmentName = document.getElementById("departmentName").value;
  var type = document.getElementById("type").value;
  createDepartment(departmentName, type);
}
/******* CREATE DEPARTMENT  *********/

/******* UPDATE DEPARTMENT  *********/
// function updateDepartment(id, departmentName, type) {
//   document.getElementById("titleModalDepartment").innerHTML =
//     "Update Department";
//   document.getElementById("id").value = id;
//   document.getElementById("departmentName").value = departmentName;
//   document.getElementById("type").value = type;

//   var button = document.getElementById("saveDepartment");
//   button.innerHTML = "Update";
//   button.onclick = function () {
//     updateDepartmentSubmit(id);
//   };
//   openModalDepartment();
// }
function openUpdateModal(id) {
  resetFormUpdateDepartment();
  $(".add-new-department").attr("disabled", "disabled");
  $.ajax({
    url: "http://localhost:8080/v2/api/departments/" + id,
    type: "GET",
    contentType: "application/json",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    success: function (data, status, xhr) {
      openModalDepartment();

      document.getElementById("titleModalDepartment").innerHTML =
        "Update Department";
      document.getElementById("departmentName").value = data.name;
      document.getElementById("type").value = data.type;

      var button = document.getElementById("saveDepartment");
      button.innerHTML = "Update";
      button.onclick = function () {
        updateDepartmentSubmit(id);
      };
    },
    error: function (data, status) {
      alert("Error when loading data");
    },
  });
}
function updateDepartmentSubmit(id) {
  var departmentName = document.getElementById("departmentName").value;
  var type = document.getElementById("type").value;

  $.ajax({
    url: "http://localhost:8080/v2/api/departments/" + id,
    type: "PUT",
    headers: { Authorization: "Basic " + btoa(username + ":" + password) },
    contentType: "application/json",
    data: `{"name":"${departmentName}","type":"${type}"}`,
    success: function (listData, status, xhr) {
      if (status == "success") {
        alert("Update thành công");
        hideModalDepartment();
        resetTableDepartment();
        buildTableDepartment();
      }
    },
    error: function (data, status) {
      alert("Update không thành công");
    },
  });
  $(".add-new-department").removeAttr("disabled");
}
function resetFormUpdateDepartment() {
  document.getElementById("titleModalDepartment").innerHTML =
    "Update Department";
  document.getElementById("departmentName").value = "";
  document.getElementById("type").value = "";
}
/******* UPDATE DEPARTMENT  *********/

/******* SEARCH  *********/
function SearchDepartment() {
  var s = document.getElementById("input-search-department").value;
  if (searchD != s) {
    searchD = s;
    resetPagingD();
    resetCheckBoxAllDepartment();
    buildTableDepartment();
  }
}
function resetTableDepartment() {
  resetPagingD();
  resetSearchDepartment();
  resetCheckBoxAllDepartment();
}
function resetSearchDepartment() {
  document.getElementById("input-search-department").value = "";
}
/******* SEARCH  *********/
