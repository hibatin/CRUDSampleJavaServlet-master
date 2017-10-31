<%--
  Created by IntelliJ IDEA.
  User: kristiawan
  Date: 10/8/17
  Time: 11:18 PM
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
</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse">
        <a class="navbar-brand" href="#">CRUD Java Servlet</a>
        <ul class="nav navbar-nav">
            <li>
                <a href="/mahasiswa">Master Mahasiswa</a>
            </li>
            <li class="active">
                <a href="/jurusan">Master Jurusan</a>
            </li>
            <li>
                <a href="/transaksikrs">Master Matakuliah</a>
            </li>
        </ul>
    </nav>
    <div class="">
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <form action="/jurusan" method="post" class="form-horizontal" role="form">
                <div class="form-group">
                    <legend>Tambah Jurusan</legend>
                </div>
                <div class="form-group">
                    <label for="kode" class="col-sm-2 control-label">Kode</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="kode" name="kode" placeholder="Kode">
                    </div>
                </div>
                <div class="form-group">
                    <label for="nama" class="col-sm-2 control-label">Nama</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nama" name="nama" placeholder="Nama">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-10 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary pull-right">Save</button>
                    </div>
                </div>
            </form>
        </div>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>No</th>
                <th>Kode</th>
                <th>Nama</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${jurusans}" var="jurusan" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${jurusan.kode}</td>
                    <td>${jurusan.nama}</td>
                    <td>
                        <a href="#modal-edit-${loop.index+1}" class="btn btn-primary btn-sm" data-toggle="modal"
                           href="#modal-id">Edit</a>
                        <a href="/jurusan?id=${jurusan.id}" class="btn btn-danger btn-sm">Hapus</a>
                    </td>
                </tr>
                <form action="/jurusan" method="post" class="form-horizontal" role="form">
                    <div class="modal fade" id="modal-edit-${loop.index+1}">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Update Mahasiswa</h4>
                                </div>
                                <div class="modal-body">
                                    <input type="hidden" name="id" id="id" class="form-control" value="${jurusan.id}"
                                    >

                                    <div class="row">
                                        <div class="form-group">
                                            <label for="kode" class="col-sm-2 control-label">Kode</label>
                                            <div class="col-sm-10">
                                                <input value="${jurusan.kode}" type="text" class="form-control"
                                                       id="kode" name="kode" placeholder="Kode">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="nama" class="col-sm-2 control-label">Nama</label>
                                            <div class="col-sm-10">
                                                <input value="${jurusan.nama}" type="text" class="form-control"
                                                       id="nama" name="nama" placeholder="Nama">
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
