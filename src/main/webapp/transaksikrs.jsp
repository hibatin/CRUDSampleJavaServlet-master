<%--
  Created by IntelliJ IDEA.
  User: alpin
  Date: 10/8/17
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Java servlet + jsp</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
</head>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse">
        <a class="navbar-brand" href="#">CRUD Java Servlet</a>
        <ul class="nav navbar-nav">
            <li>
                <a href="/mahasiswa">Master Mahasiswa</a>
            </li>
            <li>
                <a href="/jurusan">Master Jurusan</a>
            </li>
            <li class="active">
                <a href="/transaksikrs">Master Matakuliah</a>
            </li>
        </ul>
    </nav>
    <div class="form-group">
        <form action="/transaksikrs" method="post" class="form-horizontal" role="form" name="add_name" id="add_name">
            <div class="form-group">
                <legend>Tambah Transaksi</legend>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered" id="dynamic_field">
                    <tr>
                        <td> <select name="kodeMatkul" id="kodeMatkul" class="form-control">
                            <c:forEach items="${matakuliahs}" var="matakuliah" varStatus="loop">
                                <option value="${matakuliah.kode}">${matakuliah.kode} </option>
                            </c:forEach>
                        </select></td>
                        <td><input type="text" class="form-control" id="hari" name="hari" placeholder="hari"></td>
                        <td><input type="text" class="form-control" id="jam" name="jam" placeholder="Jam"></td>
                        <td><button type="button" name="add" id="add" class="btn btn-success">Add More</button></td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-primary pull-right">Save</button>
            </div>
        </form>
    </div>





        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>No</th>
                <th>Kode</th>
                <th>Hari</th>
                <th>Jam</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${transaksis}" var="transaksikrs" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${transaksikrs.kodeMatkul}</td>
                    <td>${transaksikrs.hari}</td>
                    <td>${transaksikrs.jam}</td>

                    <td>
                        <a href="#modal-edit-${loop.index+1}" class="btn btn-primary btn-sm" data-toggle="modal"
                           href="#modal-id">Edit</a>
                        <a href="/transaksikrs?id=${transaksikrs.id}" class="btn btn-danger btn-sm">Hapus</a>
                    </td>
                </tr>
                <form action="/transaksikrs" method="post" class="form-horizontal" role="form">
                    <div class="modal fade" id="modal-edit-${loop.index+1}">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Update Transaksi</h4>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" name="id" id="id" class="form-control" value="${transaksikrs.id}"
                                           >

                                    <div class="row">
                                        <div class="form-group">
                                            <label for="kode" class="col-sm-2 control-label">Kode</label>
                                            <div class="col-sm-10">
                                                <input value="${transaksikrs.kodeMatkul}" type="text" class="form-control"
                                                       id="kode" name="kodeMatkul" placeholder="Kode">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="hari" class="col-sm-2 control-label">Hari</label>
                                            <div class="col-sm-10">
                                                <input value="${transaksikrs.hari}" type="text" class="form-control"
                                                       id="hari" name="hari" placeholder="Hari">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="jam" class="col-sm-2 control-label">Jam</label>
                                            <div class="col-sm-10">
                                                <input value="${transaksikrs.jam}" type="text" class="form-control"
                                                       id="jam" name="jam" placeholder="jam">
                                            </div>
                                        </div>

                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Update</button>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal-dialog -->
                    </div><!-- /.modal -->
                </form>
            </c:forEach>
            </tbody>
        </table>
        <ul class="pager">
            <li><a href="#">Previous</a></li>
            <li>Page 1</li>
            <li><a href="#">Next</a></li>
        </ul>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>

<script>
    $(document).ready(function(){
        var i=1;
        $('#add').click(function(){
            i++;
            $('#dynamic_field').append('<tr id="row'+i+'"><td> <select name="matakuliah" id="matakuliah" class="form-control">\n' +
                '                            <c:forEach items="${matakuliahs}" var="matakuliah" varStatus="loop">\n' +
                '                                <option value="${matakuliah.kode}">${matakuliah.kode} </option>\n' +
                '                            </c:forEach>\n' +
                '\n' +
                '                        </select></td>' +
                '<td><input type="text" class="form-control" id="hari" name="hari" placeholder="hari"></td>'+
                '<td><input type="text" class="form-control" id="jam" name="jam" placeholder="Jam"></td>'+
                '<td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');
        });
        $(document).on('click', '.btn_remove', function(){
            var button_id = $(this).attr("id");
            $('#row'+button_id+'').remove();
        });

    });
</script>

