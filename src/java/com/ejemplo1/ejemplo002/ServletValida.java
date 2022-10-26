/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo1.ejemplo002;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josep
 */
//cambiamos el  urlPatterns por Valida que la ruta a donde envia el  ajax
@WebServlet(name = "ServletValida", urlPatterns = {"/Valida"})
public class ServletValida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recogiendo  los parametros de ajax
        //request maneja todos los input (entradas)
        String nombre = request.getParameter("nombre");
        String nacimiento = request.getParameter("nacimiento");
        String sueldo = request.getParameter("sueldo");
        String msg = "";

        //Validando el Nombre
        if (nombre.trim().length() > 0) {
            msg += "Nombre: " + nombre + " (OK)<br>";
        } else {
            msg += "Nombre: <span style='color:red'>No Ingresado!</span><br>";
        }

        //Validando Fecha de Nacimiento
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = sdf.parse(nacimiento);
            msg += "Nacimiento: " + nacimiento + " (OK)<br>";
        } catch (ParseException e) {
            msg += "Nacimiento: <span style='color:red'>Errado!</span><br>";
        }

        //Validando el Sueldo
        try {
            double salario = Double.valueOf(sueldo);
            msg += "Sueldo: " + sueldo + " (OK)<br>";
        } catch (NumberFormatException e) {
            msg += "Sueldo: <span style='color:red'>Errado!</span><br>";
        }

        // formato  a presentar el  resultado  como  respuesta
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // lo que devuelve el  servelet
        out.print(msg);
        out.close();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
