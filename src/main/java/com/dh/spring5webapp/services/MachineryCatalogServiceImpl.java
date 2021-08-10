package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryCatalogCommand;
import com.dh.spring5webapp.model.MachineryCatalog;
import com.dh.spring5webapp.repositories.MachineryCatalogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MachineryCatalogServiceImpl extends GenericServiceImpl<MachineryCatalog> implements MachineryCatalogService {
    private static Logger logger = LoggerFactory.getLogger(MachineryServiceImpl.class);
    private MachineryCatalogRepository machineryCatalogRepository;

    public MachineryCatalogServiceImpl(MachineryCatalogRepository machineryCatalogRepository) {
        this.machineryCatalogRepository = machineryCatalogRepository;
    }

    @Override
    protected CrudRepository<MachineryCatalog, Long> getRepository() {
        return machineryCatalogRepository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        MachineryCatalog machineryCatalogPersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            machineryCatalogPersisted.setImage(bytes);
            getRepository().save(machineryCatalogPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }


    }

    @Override
    public MachineryCatalog findByIdNotDeleted(Long id) {
        MachineryCatalog machinery = machineryCatalogRepository.findById(id).get();
        MachineryCatalog res = new MachineryCatalog();
        if (machinery.isDeleted() == false) {
            res = machinery;
        }
        return res;
    }


    @Override
    public MachineryCatalog updateMachineryCatalog(MachineryCatalogCommand machineryCatalog) {
        MachineryCatalog machineryCatalog1 = machineryCatalogRepository.findById(machineryCatalog.getId()).get();
        machineryCatalog1.setName(machineryCatalog.getMachinerycatalogName());
        machineryCatalog1.setCod(machineryCatalog.getMachinerycatalogCod());
        machineryCatalog1.setCharacteristics(machineryCatalog.getCharacteristics());
        MachineryCatalog machineryCatalogPersiste = machineryCatalogRepository.save(machineryCatalog1);
        return machineryCatalogPersiste;
    }

    @Override
    public List<MachineryCatalogCommand> getAllMachineryCatalog() {
     /*   List<MachineryCatalogCommand> machineryCatalogList = new ArrayList<>();
        machineryCatalogRepository.findAll().forEach(machineryCatalog -> {
            machineryCatalogList.add(new MachineryCatalogCommand(machineryCatalog));
        });
        return machineryCatalogList;
    }*/
        List<MachineryCatalogCommand> machineryList = verificarDelete();
        return machineryList;

    }

    public List<MachineryCatalogCommand> verificarDelete() {
        List<MachineryCatalogCommand> machineryList = new ArrayList<>();
        machineryCatalogRepository.findAll().forEach(machineryCatalog -> {
            machineryList.add(new MachineryCatalogCommand(machineryCatalog));
        });
        List<MachineryCatalogCommand> machineryR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (machineryList.size() > i) {
            valor = machineryList.get(i).isDeleted();
            if (valor == false) {
                machineryR.add(machineryList.get(i));
            }
            i++;
        }
        return machineryR;
    }

    @Override
    public void deleted(Long id) {

     /*   MachineryCatalog machineryCatalog = machineryCatalogRepository.findById(id).get();
        machineryCatalog.setDescription(null);
        machineryCatalog.setCharacteristics(null);
        machineryCatalog.setName(null);

        MachineryCatalog machineryCatalog1= machineryCatalogRepository.save(machineryCatalog);
    }*/

        MachineryCatalog machineryToDelete = machineryCatalogRepository.findById(id).get();
        machineryToDelete.setDeleted(true);

        machineryCatalogRepository.save(machineryToDelete);

    }
}