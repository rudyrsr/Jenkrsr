package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.services.CategoryService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import java.util.List;

public class CategoryControllerTest {
    @Mock
    CategoryService categoryService;
    @Mock
    private Model model;
    @InjectMocks
    CategoryController categoryController;

    private List<Category> categoryList;

    /*@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryList = new ArrayList<>();
        categoryList.add(new Category());
        when(categoryService.find(any())).thenReturn(categoryList);
    }*/

/*
    @Test
    public void testGetCategories() throws Exception {
        ArgumentCaptor<List<Category>> argumentCaptor = ArgumentCaptor.forClass((Class<List<Category>>) categoryList.getClass());
        String result = categoryController.getCategories(null, model);
        String expectedView = "categories";
        assertEquals(expectedView, result);
        verify(categoryService, times(1)).find(any());
        verify(model, times(1)).addAttribute(expectedView, categoryList);

        verify(model, times(1)).addAttribute(eq("categories"), argumentCaptor.capture());
        List<Category> capturedCategories = argumentCaptor.getValue();
        assertEquals(capturedCategories.size(), 1);
    }
*/
}