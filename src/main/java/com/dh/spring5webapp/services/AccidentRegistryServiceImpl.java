package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AccidentRegistryComand;
import com.dh.spring5webapp.command.CalendaryCommand;
import com.dh.spring5webapp.model.AccidentRegistry;
import com.dh.spring5webapp.repositories.AccidentRegistryRepository;
import com.dh.spring5webapp.repositories.AccidentRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccidentRegistryServiceImpl extends GenericServiceImpl<AccidentRegistry> implements AccidentRegitryService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private AccidentRegistryRepository accidentRegistryRepository;


    @Override
    public List<AccidentRegistryComand> getAllaccidents() {
        List<AccidentRegistryComand> accidentList = verificarDelete();
        return accidentList;

    }

    @Override
    public AccidentRegistryComand findByIdRA(Long id) {
        AccidentRegistryComand accidentComand = new AccidentRegistryComand(accidentRegistryRepository.findById(id).get());
        AccidentRegistryComand res = new AccidentRegistryComand();
        if (accidentComand.isDeleted() == false) {
            res = accidentComand;
        }
        return res;
    }

    @Override
    public AccidentRegistry createRegistryA(AccidentRegistryComand modelN) {
        AccidentRegistry model = modelN.toDomain();
        if (!Verificar(modelN.getEmployeeId(),modelN.getAccidentId())){
        model.setEmployee(employeeRepository.findById(modelN.getEmployeeId()).get());
        model.setAccident(accidentRepository.findById(modelN.getAccidentId()).get());
        return accidentRegistryRepository.save(model);
        }
        return new AccidentRegistry();
    }

    @Override
    public AccidentRegistry updateRegistyA(AccidentRegistryComand modelN) {
        AccidentRegistry model = accidentRegistryRepository.findById(modelN.getAccidentRid()).get();
        model.setAccidentRegistryDate(modelN.getAccidentRegistryDate());
        model.setAccidentRegistryHour(modelN.getAccidentRegistryHour());
        model.setEmployee(employeeRepository.findById(modelN.getEmployeeId()).get());
        model.setAccident(accidentRepository.findById(modelN.getAccidentId()).get());
        return accidentRegistryRepository.save(model);
    }

    @Override
    public void deleteAccident(Long i) {
        AccidentRegistry ac = accidentRegistryRepository.findById(i).get();
        accidentRegistryRepository.deleteById(i);
    }

    @Override
    public void desactivateAccidentR(Long id) {
        AccidentRegistry accident = accidentRegistryRepository.findById(id).get();
        accident.setDeleted(true);
        accidentRegistryRepository.save(accident);
    }

    public List<AccidentRegistryComand> verificarDelete() {
        List<AccidentRegistryComand> accidentComandList = new ArrayList<>();
        accidentRegistryRepository.findAll().forEach(accident -> {
            accidentComandList.add(new AccidentRegistryComand(accident));
        });
        List<AccidentRegistryComand> accidentComandsR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (accidentComandList.size() > i) {
            valor = accidentComandList.get(i).isDeleted();
            if (valor == false) {
                accidentComandsR.add(accidentComandList.get(i));
            }
            i++;
        }
        return accidentComandsR;
    }

    @Override
    public boolean Verificar(Long employeid, Long accidentid) {

        List<AccidentRegistryComand> accidentList = new ArrayList<>();
        accidentRegistryRepository.findAll().forEach(accidents -> {
            accidentList.add(new AccidentRegistryComand(accidents));
        });
        int i = 0;
        boolean result = false;
        while (accidentList.size() > i) {
            Long accident = accidentList.get(i).getAccident().getId();
            Long employe = accidentList.get(i).getEmployee().getId();
            if ((accident.equals(accidentid)) && (employe.equals(employeid))) {
                result = true;
                i = accidentList.size();

            } else {
                i++;
            }
        }
        return result;
    }
    @Override
    public List<AccidentRegistryComand> AccidentMes(Long mes,Long anio)
    {
        List<AccidentRegistryComand> accidentComandList = new ArrayList<>();
        accidentRegistryRepository.findAll().forEach(accident -> {
            accidentComandList.add(new AccidentRegistryComand(accident));
        });
        List<AccidentRegistryComand> accidentComandsR = new ArrayList<>();
        int i = 0;
        Date valor=new Date();
        int mess=0;
        int año=0;
        Calendar fecha = Calendar.getInstance();
        while (accidentComandList.size() > i) {
            fecha.setTime(accidentComandList.get(i).getAccidentRegistryDate());
            año=fecha.get(Calendar.YEAR);
            mess=fecha.get(Calendar.MONTH)+1;
            if (mess==mes && año==anio) {
                accidentComandsR.add(accidentComandList.get(i));
            }
            i++;
        }
        return accidentComandsR;
    }
    @Override
    public List<AccidentRegistryComand> AccidentYear(Long anio)
    {
        List<AccidentRegistryComand> accidentComandList = new ArrayList<>();
        accidentRegistryRepository.findAll().forEach(accident -> {
            accidentComandList.add(new AccidentRegistryComand(accident));
        });
        List<AccidentRegistryComand> accidentComandsR = new ArrayList<>();
        int i = 0;
        Date valor=new Date();
        int año=0;
        Calendar fecha = Calendar.getInstance();
        while (accidentComandList.size() > i) {
            fecha.setTime(accidentComandList.get(i).getAccidentRegistryDate());
            año=fecha.get(Calendar.YEAR);
            if (año==anio) {
                accidentComandsR.add(accidentComandList.get(i));
            }
            i++;
        }
        return accidentComandsR;
    }
    @Autowired
    public List<CalendaryCommand> getMounthss()
    {
        List<CalendaryCommand> Mounths=new ArrayList<>();
        CalendaryCommand ene= new CalendaryCommand(Long.valueOf(1),"January");
        CalendaryCommand feb= new CalendaryCommand(Long.valueOf(2),"February");
        CalendaryCommand mar= new CalendaryCommand(Long.valueOf(3),"March");
        CalendaryCommand abr= new CalendaryCommand(Long.valueOf(4),"April");
        CalendaryCommand may= new CalendaryCommand(Long.valueOf(5),"may");
        CalendaryCommand jun= new CalendaryCommand(Long.valueOf(6),"June");
        CalendaryCommand jul= new CalendaryCommand(Long.valueOf(7),"July");
        CalendaryCommand agos= new CalendaryCommand(Long.valueOf(8),"August");
        CalendaryCommand sep= new CalendaryCommand(Long.valueOf(9),"September");
        CalendaryCommand oct= new CalendaryCommand(Long.valueOf(10),"October");
        CalendaryCommand nov= new CalendaryCommand(Long.valueOf(11),"November");
        CalendaryCommand dic= new CalendaryCommand(Long.valueOf(12),"December");
        Mounths.add(ene);Mounths.add(feb);Mounths.add(mar);Mounths.add(abr);Mounths.add(may);
        Mounths.add(jun);Mounths.add(jul);Mounths.add(agos);Mounths.add(sep);Mounths.add(oct);
        Mounths.add(nov);Mounths.add(dic);
        return Mounths;

    }
    @Override
    protected CrudRepository<AccidentRegistry, Long> getRepository() {
        return null;
    }
}
