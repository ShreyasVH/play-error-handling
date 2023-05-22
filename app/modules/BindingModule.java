package modules;

import com.google.inject.AbstractModule;
import services.BookService;
import services.impl.BookServiceImpl;

public class BindingModule extends AbstractModule
{
    protected void configure()
    {
        bind(BookService.class).to(BookServiceImpl.class);
    }
}