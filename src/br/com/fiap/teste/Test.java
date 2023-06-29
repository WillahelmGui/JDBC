package br.com.fiap.teste;



import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioDAO;

public class Test {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario guilherme = new Usuario( "Guilherme Ribeiro", "123321");
		Usuario miguel = new Usuario("Miguel", "123456");
		Usuario emerson = new Usuario  ("Emerson", "123456");
		Usuario matheus = new Usuario("Matheus", "abc");
		Usuario jessica = new Usuario("Jessica", "abcdef");
		
		//List<Usuario> lista = dao.selectAll();
		
//		for (Usuario usuario : lista) {
//			System.out.printf("ID: %S |Nome : %S | Data de criação da conta: %S  \n", usuario.getId(),usuario.getNome(),usuario.getData());//Imprime a lista.
//		}
//		System.out.printf("ID: %S |Nome : %S | Data de criação da conta: %S  \n",
//				dao.selectById(3).getId(),dao.selectById(3).getNome(),dao.selectById(3).getData());
//	
		Usuario usuario = dao.selectById(5);
		usuario.setNome("Miguel Arcanjo");
		usuario.setSenha("miguel123");
		
		dao.update(usuario);
	}
}
