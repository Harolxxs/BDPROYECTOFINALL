<%-- 
    Document   : autoo
    Created on : 28/05/2026, 11:06:14 a. m.
    Author     : harol
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Auto_1"%>
<%@page import="controlador.Auto_1JpaController"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%
    // 1. Inicialización del EntityManagerFactory (Unidad de Persistencia)
   
    // Forzamos la creación de una nueva factoría con los cambios del persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "com.mycompany_AUTOFIELS.A_war_1.0-SNAPSHOTPU"
    );
    application.setAttribute("emf", emf);
    
    Auto_1JpaController controller = new Auto_1JpaController(emf);
    String mensaje = "";
    // ... resto del código igual

    // 3. Procesamiento del Formulario (POST)
    if ("POST".equals(request.getMethod())) {
        try {
            String placa          = request.getParameter("placa");
            String marca          = request.getParameter("marca");
            int modelo            = Integer.parseInt(request.getParameter("modelo"));
            String color          = request.getParameter("color");
            BigDecimal valorVenta = new BigDecimal(request.getParameter("valorVenta"));
            
            Auto_1 auto = new Auto_1(placa, marca, modelo, color, valorVenta);
            
            controller.create(auto);
            mensaje = "Auto guardado correctamente.";
        } catch (Exception e) {
            mensaje = "Error al guardar: " + e.getMessage();
        }
    }
    
    // 4. Carga de la lista de objetos desde la Base de Datos
    // Al usar java.util.List explícitamente evitamos cualquier ambigüedad en el JSP
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
        input[type=text], input[type=number] {
            width: 100%; padding: 8px; margin: 6px 0 12px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        label { font-weight: bold; font-size: 14px; }
        button { background: #1E88E5; color: white; padding: 10px 20px;
                 border: none; border-radius: 4px; cursor: pointer; font-size: 15px; }
        button:hover { background: #1565C0; }
        .mensaje-ok  { color: green; font-weight: bold; margin: 12px 0; }
        .mensaje-err { color: red;   font-weight: bold; margin: 12px 0; }
        table { width: 100%; border-collapse: collapse; margin-top: 25px;
                background: white; border-radius: 8px; overflow: hidden;
                box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
        th { background: #1E88E5; color: white; padding: 10px; text-align: left; }
        td { padding: 9px 10px; border-bottom: 1px solid #eee; }
        tr:hover td { background: #f9f9f9; }
    </style>
</head>
<body>

<h2>Registrar Auto</h2>
<div class="form-box">
    <form method="POST" action="autoo.jsp">
        <label>Placa:</label>
        <input type="text" name="placa" required placeholder="Ej: ABC-123" />
        
        <label>Marca:</label>
        <input type="text" name="marca" required />
        
        <label>Modelo (Año):</label>
        <input type="number" name="modelo" min="1900" max="2030" required />
        
        <label>Color:</label>
        <input type="text" name="color" required />
        
        <label>Valor de Venta:</label>
        <input type="number" name="valorVenta" step="0.01" required />
        
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
        <th>Placa</th>
        <th>Marca</th>
        <th>Modelo</th>
        <th>Color</th>
        <th>Valor Venta</th>
    </tr>
    <% for (Auto_1 a : autos) { %>
    <tr>
        <td><%= a.getPlaca() %></td>
        <td><%= a.getMarca() %></td>
        <td><%= a.getModelo() %></td>
        <td><%= a.getColor() %></td>
        <td>$<%= a.getValorVenta() %></td>
    </tr>
    <% } %>
    <% if (autos.isEmpty()) { %>
    <tr><td colspan="5" style="text-align:center;color:#999;">No hay autos registrados.</td></tr>
    <% } %>
</table>

</body>
</html>
