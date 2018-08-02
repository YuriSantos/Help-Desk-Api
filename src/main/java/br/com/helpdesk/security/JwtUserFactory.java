package br.com.helpdesk.security;

import br.com.helpdesk.entity.User;
import br.com.helpdesk.enums.ProfileEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

//Classe responsável por converter o modelo usuário para o Spring Security.
public class JwtUserFactory {

    private JwtUserFactory(){

    }

    //Metodo responsável por criar um usuário do tipo Token com base nos dados do Usuário.
    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getProfile()));
    }

    //Metodo responsável por converter os dados do usuário para o Spring Security.
    public static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
        return authorities;
    }
}
