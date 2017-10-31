package com.greenlabs.crudsample.servlet;

import com.greenlabs.crudsample.entity.Jurusan;
import com.greenlabs.crudsample.entity.Mahasiswa;
import com.greenlabs.crudsample.service.JurusanService;
import com.greenlabs.crudsample.service.MahasiswaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kristiawan on 10/8/17.
 */
@WebServlet("/mahasiswa")
public class MahasiswaServlet extends HttpServlet {

    private MahasiswaService service = new MahasiswaService();
    private JurusanService jurusanService = new JurusanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            service.delete(Long.parseLong(id));
            resp.sendRedirect("/mahasiswa");
        }

        List<Mahasiswa> mahasiswas = service.find(0, 0);
        req.setAttribute("mahasiswas", mahasiswas);
        List<Jurusan> jurusans = jurusanService.find(0,0);
        req.setAttribute("jurusans", jurusans);
        req.getRequestDispatcher("/mahasiswa.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Mahasiswa mahasiswa = new Mahasiswa();
        if (req.getParameter("id") != null){
            mahasiswa.setId(Long.parseLong(req.getParameter("id")));
        }

        mahasiswa.setNim(req.getParameter("nim"));
        mahasiswa.setNama(req.getParameter("nama"));
        mahasiswa.setAlamat(req.getParameter("alamat"));
        mahasiswa.setJurusan(req.getParameter("jurusan"));

        service.Save(mahasiswa);
        resp.sendRedirect("/mahasiswa");
    }
}
