package ru.sferum.bookmvp.mapper;

import org.mapstruct.Mapper;
import ru.sferum.bookmvp.dto.AccountDto;
import ru.sferum.bookmvp.dto.BookDto;
import ru.sferum.bookmvp.dto.ProductNoPriceDto;
import ru.sferum.bookmvp.model.Account;
import ru.sferum.bookmvp.model.Book;
import ru.sferum.bookmvp.model.Product;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountDto fromEntityToDto(Account account);

    Account fromDtoToEntity(AccountDto accountDto);

    ProductNoPriceDto fromEntityToDto(Product product);

    Product fromDtoToEntity(ProductNoPriceDto productNoPriceDto);

    BookDto fromEntityToDto(Book book);

    Book fromDtoToEntity(BookDto bookDto);

}
