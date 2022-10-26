
// petición asincrona
$(function () {
    $("#boton").click(function () {
        $.ajax({
            url: "ValidaServlet", // enviamos a un servlet
            data: {
                nombre: $("#nombre").val(),
                nacimiento: $("#nacimiento").val(),
                sueldo: $("#sueldo").val()
            },
            type: "post",
            success: function (data) {
                $("#msg").html(data); // muestra lo que devuelva el servelet
            }
        });
    });
});
