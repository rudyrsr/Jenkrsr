/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ItemCommand;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.SubCategory;

import java.io.InputStream;
import java.util.List;

public interface ItemService extends GenericService<Item> {
    void saveImage(Long id, InputStream file);

    Item updateItem(ItemCommand itemCommand, Item item, SubCategory subCategory);

    List<ItemCommand> getItems();

    ItemCommand findByIdItem(Long id);

    void desactiveItem(Long id);
}