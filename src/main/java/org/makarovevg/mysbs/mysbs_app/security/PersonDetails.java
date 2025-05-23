package org.makarovevg.mysbs.mysbs_app.security;

import org.makarovevg.mysbs.mysbs_app.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;


//представляет детали нашей сущности, классом обёрткой, нужен только спрингу
public class PersonDetails implements UserDetails {

    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return person.getRoles();
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getPersonName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
