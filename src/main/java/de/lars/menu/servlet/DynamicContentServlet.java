/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author syrinx
 */
@WebServlet(urlPatterns = "/svg", name = "DynamicContentServlet")
public class DynamicContentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("image/svg+xml");
        String name = req.getParameter("name");
        if (name == null) {
            name = "";
        }
        String svg = "<?xml version='1.0' encoding='UTF-8' standalone='no'?>"
                + "<svg  xmlns='http://www.w3.org/2000/svg' "
                + "xmlns:xlink='http://www.w3.org/1999/xlink'>"
                + "<rect x='0' y='0' height='500' width='500' "
                + "style=' fill: #90C3D4'/><text x='30' y='30' fill='red'>"
                + name + "</text>" + "</svg>";
        resp.getWriter().write(svg);
    }
}
