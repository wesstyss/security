package web.service;


import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.model.Role;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
        addDefaultRole();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role findById(long id) {
        return roleDao.findById(id);
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return roleDao.findByIdRoles(roles);
    }

    @Override
    public void addDefaultRole() {
        addRole(new Role(1L,"ROLE_USER"));
        addRole(new Role(2L,"ROLE_ADMIN"));
    }
}
