///**
// * @author: edson
// */
//
//package com.dh.spring5webapp.bootsptrap;
//
//import com.dh.spring5webapp.model.Contract;
//import com.dh.spring5webapp.model.Employee;
//import com.dh.spring5webapp.model.Position;
//import com.dh.spring5webapp.repositories.*;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//    private CategoryRepository categoryRepository;
//    private SubCategoryRepository subCategoryRepository;
//    private ItemRepository itemRepository;
//    private EmployeeRepository employeeRepository;
//    private PositionRepository positionRepository;
//    private ContractRepository contractRepository;
//    private MachineryAssignationRepository machineryAssignationRepository;
//    private MachineryRepository machineryRepository;
//
//    public DevBootstrap(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
//                        ItemRepository itemRepository, EmployeeRepository employeeRepository,
//                        PositionRepository positionRepository, ContractRepository contractRepository,
//                        MachineryAssignationRepository machineryAssignationRepository, MachineryRepository machineryRepository) {
//
//        this.categoryRepository = categoryRepository;
//        this.subCategoryRepository = subCategoryRepository;
//        this.itemRepository = itemRepository;
//        this.employeeRepository = employeeRepository;
//        this.positionRepository = positionRepository;
//        this.contractRepository = contractRepository;
//        this.machineryAssignationRepository = machineryAssignationRepository;
//        this.machineryRepository = machineryRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
//        initData();
//    }
//
//    private void initData() {
//      /*  // EPP category
//        Category eppCategory = new Category();
//        eppCategory.setCode("EPP");
//        eppCategory.setName("EPP");
//        categoryRepository.save(eppCategory);
//
//        // RESOURCE category
//        Category resourceCategory = new Category();
//        resourceCategory.setCode("RES");
//        resourceCategory.setName("RESOURCE");
//        categoryRepository.save(resourceCategory);
//
//        SubCategory rawMaterialSubCategory = new SubCategory();
//        rawMaterialSubCategory.setCategory(resourceCategory);
//        rawMaterialSubCategory.setCode("RM");
//        rawMaterialSubCategory.setName("RAW MATERIAL");
//        subCategoryRepository.save(rawMaterialSubCategory);
//
//// safety subcategory
//        SubCategory safetySubCategory = new SubCategory();
//        safetySubCategory.setCategory(eppCategory);
//        safetySubCategory.setCode("SAF");
//        safetySubCategory.setName("SAFETY");
//
//        subCategoryRepository.save(safetySubCategory);
//
//
//        // Helmet Item
//        Item helmet = new Item();
//        helmet.setCode("HEL");
//        helmet.setName("HELMET");
//        helmet.setSubCategory(safetySubCategory);
//
//        itemRepository.save(helmet);
//
//        // ink Item
//        Item ink = new Item();
//        ink.setCode("INK");
//        ink.setName("INK");
//        ink.setSubCategory(rawMaterialSubCategory);
//        itemRepository.save(ink);
//
//        // John Employee
//        Employee john = new Employee();
//        john.setFirstName("John");
//        john.setLastName("Doe");
//
//        // Position
//        Position position = new Position();
//        position.setName("OPERATIVE");
//
////        positionRepository.save(position);
//
//        // contract
//        Contract contract = new Contract();
//        contract.setEmployee(john);
//        contract.setCreatedOn(new Date(2010, 1, 1));
//        contract.setPosition(position);
//
//        john.getContracts().add(contract);
////        employeeRepository.save(john);
////        contractRepository.save(contract);
//*/
//    }
//}