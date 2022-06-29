package com.bagofideas.springboot.error.app.services;

import com.bagofideas.springboot.error.app.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private List<User> list;

    public UserServiceImpl()
    {
        this.list = new ArrayList<>();
        this.list.add(new User(1, "Andrés", "Guzmán"));
        this.list.add(new User(2, "Pepa", "García"));
        this.list.add(new User(3, "Lalo", "Mena"));
        this.list.add(new User(4, "Luci", "Fernández"));
        this.list.add(new User(5, "Pato", "González"));
        this.list.add(new User(6, "Paco", "Rodríguez"));
        this.list.add(new User(7, "Juan", "Gómez"));
    }

    @Override
    public List<User> toList(){return this.list;}

    @Override
    public User getById(Integer id)
    {
        User result = null;
        for (User u: this.list)
        {
            if(u.getId().equals(id))
            {
                result = u;
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<User> getByOptionalId(Integer id)
    {
        User user = this.getById(id);
        return Optional.ofNullable(user);
    }
}
