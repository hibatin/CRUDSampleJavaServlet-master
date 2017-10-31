package com.greenlabs.crudsample.servlet;

import com.greenlabs.crudsample.entity.Mahasiswa;
import com.greenlabs.crudsample.entity.Matakuliah;
import com.greenlabs.crudsample.entity.TransaksiKrs;
import com.greenlabs.crudsample.service.MahasiswaService;
import com.greenlabs.crudsample.service.MatakuliahService;
import com.greenlabs.crudsample.service.TransaksiKrsService;

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
@WebServlet("/transaksikrs")
public class TransaksiKrsServlet extends HttpServlet {

    private TransaksiKrsService service = new TransaksiKrsService();
    private MatakuliahService matakuliahService = new MatakuliahService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            service.delete(Long.parseLong(id));
            resp.sendRedirect("/mahasiswa");
        }

        List<TransaksiKrs> transaksiKrsList = service.find(0, 0);
        req.setAttribute("transaksis", transaksiKrsList);
        List<Matakuliah> matakuliahs = matakuliahService.find(0, 0);
        req.setAttribute("matakuliahs", matakuliahs);

        req.getRequestDispatcher("/transaksikrs.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TransaksiKrs transaksiKrs = new TransaksiKrs();
        if (req.getParameter("id") != null){
            transaksiKrs.setId(Long.parseLong(req.getParameter("id")));
        }

        transaksiKrs.setKodeMatkul(req.getParameter("kodeMatkul"));
        transaksiKrs.setHari(req.getParameter("hari"));
        transaksiKrs.setJam(Integer.parseInt(req.getParameter("jam")));

        service.Save(transaksiKrs);
        resp.sendRedirect("/transaksikrs");
    }
}
