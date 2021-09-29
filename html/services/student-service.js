const path = '/students/v1';
class StudentService {
    constructor() { }

    static getAll() {
        BaseService.getAll(path)
            .then(function (studentDtoList) {
                var content = '<table class="aca-fill">';
                content += '<tr>'
                    + '<th scope="col">Id</th>'
                    + '<th scope="col">Name</th>'
                    + '<th scope="col">Country</th>'
                    + '<th scope="col">Classroom</th>'
                    + '<th scope="col">Detail</th>'
                    + '<th scope="col">Action</th>'
                    + '</tr>';
                jQuery.each(studentDtoList, function (i, val) {
                    content += '<tr>'
                        + '<td>' + val.id + '</td>'
                        + '<td>' + val.name + '</td>'
                        + '<td>' + val.country + '</td>'
                        + '<td>' + val.classroomId + '</td>'
                        + '<td><button id="btnDetail-' + val.id + '" class="btn btn-warning" onclick="StudentService.detail(' + val.id + ')">detail</button></td>'
                        + '<td><button id="btnDelete-' + val.id + '" class="btn btn-danger" onclick="StudentService.delete(' + val.id + ')">delete</button></td>'
                        + '</tr>';
                });
                content += '</table>';

                $('#saveForm').trigger('reset');
                $('#saveForm').hide();
                $('.table').empty();
                $('.table').append(content);
                $('.table').show();
            });
    }

    static post(formData) {
        BaseService.post(path, formData)
            .then(function (studentDto) {
                window.alert("L'utente è stato salvato? " + studentDto.id !== null)
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                StudentService.getAll();
            });
    }

    static put(formData) {
        BaseService.put(path, formData)
            .then(function (studentDto) {
                window.alert("L'utente è stato Aggiornato")
                $('#saveForm').trigger('reset');
                $('#saveForm').hide();

                StudentService.getAll();
            });
    }

    static delete(id) {
        BaseService.delete(path, id)
            .then(function (result) {
                window.alert('Utente ' + id + ' eliminato con successo!')

                StudentService.getAll();
            });
    }


    static detail(id) {
        BaseService.get('/students/v1', id)
            .then(function (studentDto) {
                document.getElementById('studentId').value = studentDto.id;
                document.getElementById('name').value = studentDto.name;
                document.getElementById('classroomId').value = studentDto.classroomId;
                document.getElementById('country').value = studentDto.country;
                document.getElementById('birthDate').value = moment(studentDto.birthDate).format('YYYY-MM-DD');

                $('.table').empty();
                $('.table').hide();
                $('#saveForm').show();
            });
    }
}