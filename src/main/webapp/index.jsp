<%-- 
    Document   : index
    Created on : 23/04/2026, 7:14:16 p. m.
    Author     : harol
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Cliente_1"%>
<%@page import="controlador.Cliente_1JpaController"%>
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
    Cliente_1JpaController controller = new Cliente_1JpaController(emf);
    String mensaje = "";

    if ("POST".equals(request.getMethod())) {
        try {
            Long idCliente   = Long.parseLong(request.getParameter("idCliente"));
            String nombre    = request.getParameter("nombre");
            String apellido  = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String tipoId    = request.getParameter("tipoId");
            Cliente_1 c = new Cliente_1(idCliente, nombre, apellido, direccion, tipoId);
            controller.create(c);
            mensaje = "Cliente guardado correctamente.";
        } catch (Exception e) {
            mensaje = "Error al guardar: " + e.getMessage();
        }
    }
    List<Cliente_1> clientes = controller.findCliente_1Entities();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Clientes</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background: #f4f4f4; }
        h2   { color: #333; }
        .form-box { background: white; padding: 20px; border-radius: 8px;
                    box-shadow: 0 2px 6px rgba(0,0,0,0.1); max-width: 450px; }
        input[type=text], input[type=number] {
            width: 100%; padding: 8px; margin: 6px 0 12px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        label { font-weight: bold; font-size: 14px; }
        button { background: #4CAF50; color: white; padding: 10px 20px;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
        button:hover { background: #45a049; }
        .mensaje-ok  { color: green; font-weight: bold; margin: 12px 0; }
        .mensaje-err { color: red;   font-weight: bold; margin: 12px 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px;
                background: white; border-radius: 8px; overflow: hidden;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
        th { background: #4CAF50; color: white; padding: 10px; text-align: left; }
        td { padding: 9px 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
    </style>
</head>
<body>
<h2>Registrar Cliente</h2>
<div class="form-box">
    <form method="POST" action="index.jsp">
        <label>ID Cliente:</label>
        <input type="number" name="idCliente" required />
        <label>Nombre:</label>
        <input type="text" name="nombre" required />
        <label>Apellido:</label>
        <input type="text" name="apellido" required />
        <label>Dirección:</label>
        <input type="text" name="direccion" required />
        <label>Tipo ID:</label>
        <input type="text" name="tipoId" required />
        <button type="submit">Guardar Cliente</button>
    </form>
    <% if (!mensaje.isEmpty()) {
           boolean ok = mensaje.startsWith("Cliente"); %>
        <p class="<%= ok ? "mensaje-ok" : "mensaje-err" %>"><%= mensaje %></p>
    <% } %>
</div>

<h2>Clientes Registrados (<%= clientes.size() %>)</h2>
<table>
    <tr>
        <th>ID</th><th>Nombre</th><th>Apellido</th><th>Dirección</th><th>Tipo ID</th>
    </tr>
    <% for (Cliente_1 c : clientes) { %>
    <tr>
        <td><%= c.getIdCliente() %></td>
        <td><%= c.getNombre() %></td>
        <td><%= c.getApellido() %></td>
        <td><%= c.getDireccion() %></td>
        <td><%= c.getTipoId() %></td>
    </tr>
    <% } %>
    <% if (clientes.isEmpty()) { %>
    <tr><td colspan="5" style="text-align:center;color:#999;">No hay clientes registrados.</td></tr>
    <% } %>
</table>
</body>
</html>
