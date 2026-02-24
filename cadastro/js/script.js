document.addEventListener("DOMContentLoaded", () => {

  const form = document.getElementById("cadastro");

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const usuario = {
      nome: nome.value.trim(),
      email: email.value.trim(),
      senha: senha.value.trim(),
      perfil: perfil.value,
      endereco: endereco.value.trim(),
      bairro: bairro.value.trim(),
      complemento: complemento.value.trim(),
      cep: cep.value.trim(),
      cidade: cidade.value.trim(),
      estado: estado.value.trim()
    };

    if (!usuario.nome || !usuario.email || !usuario.senha) {
      alert("Preencha Nome, Email e Senha!");
      return;
    }

    if (usuario.senha.length < 6) {
      alert("A senha deve ter no mínimo 6 caracteres.");
      return;
    }

    console.log(usuario);

    alert("Usuário cadastrado com sucesso!");

    form.reset();
  });

});
