$(function () {
    $('.table').DataTable({
    //$("#example1").DataTable({
        "select": true,
        "colReorder": true,
        ///"responsive": true,
        "paging": true,
        "lengthChange": true,
        "searching": true,
        "ordering": true,
        "info": true,
        "autoWidth": true,
        "lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]],
        "language": {
            "lengthMenu": "Ver _MENU_ registros por página",
            "zeroRecords": "Ningun Registro - Encontrado",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registros disponibles",
            "infoFiltered": "(filtrado de _MAX_ registros totales)", "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        }
    });
});
/*
$(function () {
    $("#example1").DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros por página",
            "zeroRecords": "Nada encontrado - lo siento",
            "info": "Mostrando página PÁGINA de PÁGINAS",
            "infoEmpty": "No hay registros disponibles.",
            "infoFiltered": "(Filtrado de _MAX_ registros totales)",
            "sSearch": "Buscar:",
            "decimal": ",",
            "thousands": "."
        }
    });

    $('#example2').DataTable({
        "paging": true,
        "lengthChange": false,
        "searching": false,
        "ordering": true,
        "info": true,
        "autoWidth": false,
    });
});

*/