const API = 'http://localhost:8080/usuarios';
const tabela = document.getElementById('tabelaUsuarios');
const mensagem = document.getElementById('mensagem');

// se usar JWT, descomenta:
// const token = localStorage.getItem('token');

function carregarUsuarios() {
    fetch(API /*,{
        headers: { 'Authorization': 'Bearer ' + token }
    }*/)
    .then(res => {
        if (!res.ok) throw new Error();
        return res.json();
    })
    .then(usuarios => {
        tabela.innerHTML = '';

        if (usuarios.length === 0) {
            tabela.innerHTML = `
                <tr>
                    <td colspan="5" style="text-align:center">Nenhum usuário cadastrado</td>
                </tr>`;
            return;
        }

        usuarios.forEach(u => {
            tabela.innerHTML += `
                <tr>
                    <td>${u.nome}</td>
                    <td>${u.email}</td>
                    <td>${u.perfil}</td>
                    <td>${u.cidade || ''}</td>
                    <td>
                        <button class="editar" onclick="editar(${u.id})">Editar</button>
                        <button class="deletar" onclick="deletar(${u.id})">Excluir</button>
                    </td>
                </tr>
            `;
        });
    })
    .catch(() => {
        mensagem.innerHTML = '<span class="erro">Erro ao carregar usuários.</span>';
    });
}

function novoUsuario() {
    window.location.href = 'cadastro.html';
}

function editar(id) {
    window.location.href = `cadastro.html?id=${id}`;
}

function deletar(id) {
    if (!confirm('Deseja realmente excluir este usuário?')) return;

    fetch(`${API}/${id}`, {
        method: 'DELETE'/*,
        headers: { 'Authorization': 'Bearer ' + token }*/
    })
    .then(res => {
        if (!res.ok) throw new Error();
        carregarUsuarios();
    })
    .catch(() => {
        mensagem.innerHTML = '<span class="erro">Erro ao excluir usuário.</span>';
    });
}

carregarUsuarios();