const url = "http://localhost:8080/api/users"
const tbody = document.querySelector("tbody")
let result = ""


const show = (users) => {
    users.forEach(user => {
        result +=
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.role.toString()}</td>
                <td class="text-center"><a type="button" class="btn btn-info btn-sm" style="color: white"
                                           data-bs-toggle="modal">Edit
                </a>
                </td>
                <td><a type="button" className="btn btn-info btn-sm" style="color: white"
                       data-bs-toggle="modal">Edit
                </a></td>
            </tr>
    })

    tbody.innerHTML = result
}


let response = await fetch(url);
let users = await response.json();
show(users)