/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
@WebServlet(urlPatterns = "/image", name = "DynamicContentServletImage")
public class ImageServlet extends HttpServlet {

    final String DIR = "k:\\Programmierung\\Java\\netbeans\\demo_10_menu_git\\src\\main\\webapp\\images\\";
    //final String DIR = "c:\\_Tests\\netbeans\\demo_10_menu_git\\src\\main\\webapp\\images\\";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedOutputStream output = null;
        try {
            String fileName = request.getParameter("name");
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            FileInputStream fis = new FileInputStream(new File(DIR + fileName));
            BufferedInputStream bis = new BufferedInputStream(fis);
            response.setContentType("image/jpeg");
            output = new BufferedOutputStream(response.getOutputStream());
            for (int data; (data = bis.read()) > -1;) {
                output.write(data);
            }
        } catch (IOException e) {

        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}
