<%-- 
    Document   : auto
    Created on : 28/05/2026, 8:55:28 p. m.
    Author     : Malguz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Auto_1"%>
<%@page import="controlador.Auto_1JpaController"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%
    EntityManagerFactory emf = (EntityManagerFactory) application.getAttribute("emf");
    if (emf == null) {
        emf = Persistence.createEntityManagerFactory(
            "com.mycompany_AUTOFIELS.A_war_1.0-SNAPSHOTPU"
        );
        application.setAttribute("emf", emf);
    }
    Auto_1JpaController controller = new Auto_1JpaController(emf);
    String mensaje = "";

    if ("POST".equals(request.getMethod())) {
        try {
            String marca     = request.getParameter("marca");
            int modelo       = Integer.parseInt(request.getParameter("modelo"));
            String color     = request.getParameter("color");
            String condicion = request.getParameter("condicion");
            String placa     = request.getParameter("placa");
            double precio    = Double.parseDouble(request.getParameter("precio"));

            Auto_1 a = new Auto_1(marca, modelo, color, condicion, placa, precio);
            controller.create(a);
            mensaje = "Auto guardado correctamente.";
        } catch (Exception e) {
            mensaje = "Error al guardar: " + e.getMessage();
        }
    }
    List<Auto_1> autos = controller.findAuto_1Entities();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Autos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f4f4f4; }
        h2   { color: #333; }
        .form-box { background: white; padding: 20px; border-radius: 8px;
                    box-shadow: 0 2px 6px rgba(0,0,0,0.1); max-width: 450px; }
        input[type=text], input[type=number], select {
            width: 100%; padding: 8px; margin: 6px 0 12px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        label { font-weight: bold; font-size: 14px; }
        button { background: #FF5722; color: white; padding: 10px 20px;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
        button:hover { background: #E64A19; }
        .mensaje-ok  { color: green; font-weight: bold; margin: 12px 0; }
        .mensaje-err { color: red;   font-weight: bold; margin: 12px 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px;
                background: white; border-radius: 8px; overflow: hidden;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
        th { background: #FF5722; color: white; padding: 10px; text-align: left; }
        td { padding: 9px 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
        .back { margin-bottom: 20px; display: inline-block; color: #FF5722; text-decoration: none; font-weight: bold; }
    </style>
</head>
<body>

<a class="back" href="principal.jsp">← Volver al menú</a>
<h2>Registrar Auto</h2>
<div class="form-box">
    <form method="POST" action="auto.jsp">
        <label>Marca:</label>
        <input type="text" name="marca" required />

        <label>Modelo (año):</label>
        <input type="number" name="modelo" min="1900" max="2100" required />

        <label>Color:</label>
        <input type="text" name="color" required />

        <label>Condición:</label>
        <select name="condicion">
            <option value="Nuevo">Nuevo</option>
            <option value="Usado">Usado</option>
        </select>

        <label>Placa:</label>
        <input type="text" name="placa" required />

        <label>Precio ($):</label>
        <input type="number" name="precio" step="0.01" min="0" required />

        <button type="submit">Guardar Auto</button>
    </form>
    <% if (!mensaje.isEmpty()) {
           boolean ok = mensaje.startsWith("Auto"); %>
        <p class="<%= ok ? "mensaje-ok" : "mensaje-err" %>"><%= mensaje %></p>
    <% } %>
</div>

<h2>Autos Registrados (<%= autos.size() %>)</h2>
<table>
    <tr>
        <th>ID</th><th>Marca</th><th>Modelo</th><th>Color</th>
        <th>Condición</th><th>Placa</th><th>Precio</th>
    </tr>
    <% for (Auto_1 a : autos) { %>
    <tr>
        <td><%= a.getIdAuto() %></td>
        <td><%= a.getMarca() %></td>
        <td><%= a.getModelo() %></td>
        <td><%= a.getColor() %></td>
        <td><%= a.getCondicion() %></td>
        <td><%= a.getPlaca() %></td>
        <td>$<%= String.format("%,.2f", a.getPrecio()) %></td>
    </tr>
    <% } %>
    <% if (autos.isEmpty()) { %>
    <tr><td colspan="7" style="text-align:center;color:#999;">No hay autos registrados.</td></tr>
    <% } %>
</table>
</body>
</html>
