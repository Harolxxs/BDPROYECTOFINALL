<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Vendedor_1"%>
<%@page import="controlador.Vendedor_1JpaController"%>
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
    Vendedor_1JpaController controller = new Vendedor_1JpaController(emf);
    String mensaje = "";

    if ("POST".equals(request.getMethod())) {
        try {
            Long idVendedor = Long.parseLong(request.getParameter("idVendedor"));
            String nombre   = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo   = request.getParameter("correo");
            Vendedor_1 v = new Vendedor_1(idVendedor, nombre, apellido, correo);
            controller.create(v);
            mensaje = "Vendedor guardado correctamente.";
        } catch (Exception e) {
            mensaje = "Error al guardar: " + e.getMessage();
        }
    }
    List<Vendedor_1> vendedores = controller.findVendedor_1Entities();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Vendedores</title>
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
        button { background: #2196F3; color: white; padding: 10px 20px;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
        button:hover { background: #1976D2; }
        .mensaje-ok  { color: green; font-weight: bold; margin: 12px 0; }
        .mensaje-err { color: red;   font-weight: bold; margin: 12px 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px;
                background: white; border-radius: 8px; overflow: hidden;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
        th { background: #2196F3; color: white; padding: 10px; text-align: left; }
        td { padding: 9px 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
    </style>
</head>
<body>
<h2>Registrar Vendedor</h2>
<div class="form-box">
    <form method="POST" action="vendedor.jsp">
        <label>ID Vendedor:</label>
        <input type="number" name="idVendedor" required />
        <label>Nombre:</label>
        <input type="text" name="nombre" required />
        <label>Apellido:</label>
        <input type="text" name="apellido" required />
        <label>Correo:</label>
        <input type="text" name="correo" required />
        <button type="submit">Guardar Vendedor</button>
    </form>
    <% if (!mensaje.isEmpty()) {
           boolean ok = mensaje.startsWith("Vendedor"); %>
        <p class="<%= ok ? "mensaje-ok" : "mensaje-err" %>"><%= mensaje %></p>
    <% } %>
</div>

<h2>Vendedores Registrados (<%= vendedores.size() %>)</h2>
<table>
    <tr>
        <th>ID</th><th>Nombre</th><th>Apellido</th><th>Correo</th>
    </tr>
    <% for (Vendedor_1 v : vendedores) { %>
    <tr>
        <td><%= v.getIdVendedor() %></td>
        <td><%= v.getNombre() %></td>
        <td><%= v.getApellido() %></td>
        <td><%= v.getCorreo() %></td>
    </tr>
    <% } %>
    <% if (vendedores.isEmpty()) { %>
    <tr><td colspan="4" style="text-align:center;color:#999;">No hay vendedores registrados.</td></tr>
    <% } %>
</table>
</body>
</html>