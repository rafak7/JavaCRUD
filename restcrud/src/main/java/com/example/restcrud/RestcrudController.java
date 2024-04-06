    package com.example.restcrud;

    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.List;

    @RestController
    @RequestMapping ("/usuarios")
    public class RestcrudController {
        private List<Usuario> usuarios = new ArrayList<>();

        @GetMapping
        public List<Usuario> listarUsuarios () {
            return usuarios;
        }

        //função: Create
        @PostMapping
        public Usuario criarUsuario(@RequestBody Usuario usuario) {
            usuario.setId(generateNextId());
            usuarios.add(usuario);
            return usuario;

    }

    //Função: Update
        @PostMapping("/{id}")
        public Usuario atualizarUsuario (@PathVariable Long id, @RequestBody Usuario usuario){
            Usuario usuarioExistente = usuarios.stream()
                    .filter(u -> u.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));

            usuarioExistente.setNome(usuario.getNome());
            // atualize outros atrubutos se necessario

            return usuarioExistente;
        }
 }