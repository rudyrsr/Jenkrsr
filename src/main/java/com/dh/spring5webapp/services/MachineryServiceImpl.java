package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryCalendaryCommand;
import com.dh.spring5webapp.command.MachineryCommand;
import com.dh.spring5webapp.model.Machinery;
import com.dh.spring5webapp.repositories.MachineryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MachineryServiceImpl extends GenericServiceImpl<Machinery> implements MachineryService {
    private static Logger logger = LoggerFactory.getLogger(MachineryServiceImpl.class);
    private MachineryRepository machineryRepository;
    private MachineryCatalogService catalogService;

    public MachineryServiceImpl(MachineryRepository machineryRepository, MachineryCatalogService catalogService) {
        this.machineryRepository = machineryRepository;
        this.catalogService = catalogService;
    }

    @Override
    protected CrudRepository<Machinery, Long> getRepository() {
        return machineryRepository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Machinery machineryPersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            machineryPersisted.setImage(bytes);
            getRepository().save(machineryPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }

    }

    @Override
    public Machinery findByIdNotDeleted(Long id) {
        Machinery machinery = machineryRepository.findById(id).get();
        Machinery res = new Machinery();
        if (machinery.isDeleted() == false) {
            res = machinery;
        }
        return res;
    }

    @Override
    public Machinery updateMachinery(MachineryCommand machinery) {
        Machinery machinery1 = machineryRepository.findById(machinery.getId()).get();
        machinery1.setMachineryCatalog(catalogService.findById(machinery.getMachineryCatalogId()));
        machinery1.setName(machinery.getMachineryName());
        machinery1.setBrand(machinery.getMachineryBrand());
        machinery1.setAvailable(machinery.getMachineryAvailable());
        machinery1.setPrice(machinery.getMachineryPrice());
        machinery1.setDateBuy(machinery.getMachineryDateBuy());
        Machinery machineryPersiste = machineryRepository.save(machinery1);
        return machineryPersiste;
    }

    @Override
    public List<MachineryCommand> getAllMachine() {
        List<MachineryCommand> machineryList = verificarDelete();
        return machineryList;

    }
    public List<MachineryCommand> verificarDelete() {
        List<MachineryCommand> machineryLista = new ArrayList<>();
        machineryRepository.findAll().forEach(machine -> {
            machineryLista.add(new MachineryCommand(machine));
        });
        List<MachineryCommand> machineryR = new ArrayList<>();
        int i = 0;
        boolean valor;
        while (machineryLista.size() > i) {
            valor = machineryLista.get(i).isDeleted();
            if (valor == false) {
                machineryR.add(machineryLista.get(i));
            }
            i++;
        }
        return machineryR;
    }

    @Override
    public void delete(Long id) {
        Machinery machineryToDelete = machineryRepository.findById(id).get();
        machineryToDelete.setDeleted(true);

        machineryRepository.save(machineryToDelete);

    }

    @Override
    public List<MachineryCommand> MachineryMes(Long mes) {
        List<MachineryCommand> machineryCommandList = new ArrayList<>();
        machineryRepository.findAll().forEach(
                machinery -> {
                    machineryCommandList.add(new MachineryCommand(machinery));

                });
        List<MachineryCommand> machinerCommandR = new ArrayList<>();
        int i = 0;
        Date valor = new Date();
        int mess = 0;

        while (machineryCommandList.size() > i) {
            valor = machineryCommandList.get(i).getMachineryDateBuy();
            mess = valor.getMonth() + 1;
            if (mess == mes) {
                machinerCommandR.add(machineryCommandList.get(i));
            }
            i++;
        }

        return machinerCommandR;
    }

    @Override
    public List<MachineryCommand> MachineryYear(Long year) {
        List<MachineryCommand> machineryCommandList = new ArrayList<>();
        machineryRepository.findAll().forEach(machinery -> {
            machineryCommandList.add(new MachineryCommand(machinery));
        });
        List<MachineryCommand> machineryComandR = new ArrayList<>();
        int i = 0;
        Date valor = new Date();
        int año = 0;
        Calendar fecha = Calendar.getInstance();
        while (machineryCommandList.size() > i) {
            fecha.setTime(machineryCommandList.get(i).getMachineryDateBuy());
            año = fecha.get(Calendar.YEAR);
            if (año == year) {
                machineryComandR.add(machineryCommandList.get(i));
            }
            i++;
        }
        return machineryComandR;
    }


    @Override
    public List<MachineryCalendaryCommand> getMounth() {
        List<MachineryCalendaryCommand> Mounths = new ArrayList<>();
        MachineryCalendaryCommand ene = new MachineryCalendaryCommand(Long.valueOf(1), "Enero");
        MachineryCalendaryCommand feb = new MachineryCalendaryCommand(Long.valueOf(2), "Febrero");
        MachineryCalendaryCommand mar = new MachineryCalendaryCommand(Long.valueOf(3), "Marzo");
        MachineryCalendaryCommand abr = new MachineryCalendaryCommand(Long.valueOf(4), "Abril");
        MachineryCalendaryCommand may = new MachineryCalendaryCommand(Long.valueOf(5), "Mayo");
        MachineryCalendaryCommand jun = new MachineryCalendaryCommand(Long.valueOf(6), "Junio");
        MachineryCalendaryCommand jul = new MachineryCalendaryCommand(Long.valueOf(7), "Julio");
        MachineryCalendaryCommand agos = new MachineryCalendaryCommand(Long.valueOf(8), "Agosto");
        MachineryCalendaryCommand sep = new MachineryCalendaryCommand(Long.valueOf(9), "Septiembre");
        MachineryCalendaryCommand oct = new MachineryCalendaryCommand(Long.valueOf(10), "Octubre");
        MachineryCalendaryCommand nov = new MachineryCalendaryCommand(Long.valueOf(11), "Noviembre");
        MachineryCalendaryCommand dic = new MachineryCalendaryCommand(Long.valueOf(12), "Diciembre");
        Mounths.add(ene);
        Mounths.add(feb);
        Mounths.add(mar);
        Mounths.add(abr);
        Mounths.add(may);
        Mounths.add(jun);
        Mounths.add(jul);
        Mounths.add(agos);
        Mounths.add(sep);
        Mounths.add(oct);
        Mounths.add(nov);
        Mounths.add(dic);
        return Mounths;
    }
}
