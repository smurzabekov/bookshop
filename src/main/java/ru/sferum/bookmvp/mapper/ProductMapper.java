package ru.sferum.bookmvp.mapper;

import org.mapstruct.Mapper;
import ru.sferum.bookmvp.dto.BookDto;
import ru.sferum.bookmvp.dto.ProductDto;
import ru.sferum.bookmvp.model.Book;
import ru.sferum.bookmvp.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto fromEntityToDto(Product product);

    Product fromDtoToEntity(ProductDto productDto);

    BookDto fromEntityToDto(Book book);

    Book fromDtoToEntity(BookDto bookDto);

}
