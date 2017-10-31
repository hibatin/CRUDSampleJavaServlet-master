package com.greenlabs.crudsample.servlet;

import com.greenlabs.crudsample.entity.Jurusan;
import com.greenlabs.crudsample.service.JurusanService;

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
@WebServlet("/jurusan")
public class JurusanServlet extends HttpServlet {

    private JurusanService service = new JurusanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            service.delete(Long.parseLong(id));
            resp.sendRedirect("/jurusan");
        }

        List<Jurusan> jurusans = service.find(0, 0);
        req.setAttribute("jurusans", jurusans);
        req.getRequestDispatcher("/jurusan.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jurusan jurusan = new Jurusan();
        if (req.getParameter("id") != null) {
            jurusan.setId(Long.parseLong(req.getParameter("id")));
        }

        jurusan.setKode(req.getParameter("kode"));
        jurusan.setNama(req.getParameter("nama"));

        service.Save(jurusan);
        resp.sendRedirect("/jurusan");
    }
}
