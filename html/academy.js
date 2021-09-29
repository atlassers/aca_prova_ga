$(document).ready(function () {
    $('#btnShow').click(function () {
        StudentService.getAll();
    });

    $('#btnAdd').click(function () {
        $('.table').empty();
        $('.table').hide();
        $('#saveForm').show();
    })

    $('#saveForm').submit(function (event) {
        event.preventDefault();

        var id = document.getElementById('studentId').value
        var name = document.getElementById('name').value;
        var country = document.getElementById('country').value;
        var classroomId = document.getElementById('classroomId').value;
        var birthDate = document.getElementById('birthDate').value + 'T00:00:00Z';

        var formData = JSON.stringify({
            'id': id,
            'name': name,
            'country': country,
            'classroomId': classroomId,
            'birthDate': birthDate
        })

        if (id) {
            StudentService.put(formData);
        } else {
            StudentService.post(formData);
        }
    });
});