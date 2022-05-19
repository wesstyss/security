package web.dao;

import web.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles ();
    void addRole(Role role);
    Role findById(long id);
    Set<Role> findByIdRoles(List<Long>roles);
}
