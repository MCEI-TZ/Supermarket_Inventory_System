package com.mceit_z.Inventory_System.services.rol.Impl;

import com.mceit_z.Inventory_System.models.Rol;
import com.mceit_z.Inventory_System.repo.IRol;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;
import com.mceit_z.Inventory_System.services.rol.RolService;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl extends GenericServiceIImpl<Rol, Long, IRol> implements RolService {
}
