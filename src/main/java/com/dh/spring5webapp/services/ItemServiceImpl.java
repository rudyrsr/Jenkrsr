/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ItemCommand;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private static Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    private ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Item, Long> getRepository() {
        return repository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Item itemPersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            itemPersisted.setImage(bytes);
            getRepository().save(itemPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

    @Override
    public Item updateItem(ItemCommand itemCommand, Item item, SubCategory subCategory) {
        item.setId(itemCommand.getId());
        item.setState(itemCommand.getState());
        item.setDescription(itemCommand.getDescription());
        item.setName(itemCommand.getName());
        item.setCode(itemCommand.getCode());
        item.setPrice(itemCommand.getPrice());
        item.setSubCategory(subCategory);
        item.setLabel(itemCommand.getLabel());
        return item;
    }

    @Override
    public List<ItemCommand> getItems() {
        List<ItemCommand> itemlist = new ArrayList<>();
        repository.findAll().forEach(item -> {
            itemlist.add(new ItemCommand(item));
        });
        List<ItemCommand> seleccionItem = new ArrayList<>();
        int i = 0;
        while (itemlist.size() > i) {
            if (itemlist.get(i).getFeatured() == false) {
                seleccionItem.add(itemlist.get(i));
            }
            i++;
        }
        return seleccionItem;
    }

    @Override
    public ItemCommand findByIdItem(Long id) {
        ItemCommand itemCommand = new ItemCommand(repository.findById(id).get());
        ItemCommand res = new ItemCommand();
        if (itemCommand.getFeatured() == false) {
            res = itemCommand;
        }
        return res;
    }

    @Override
    public void desactiveItem(Long id) {
        Item item = repository.findById(id).get();
        item.setDeleted(true);
        repository.save(item);
    }
}