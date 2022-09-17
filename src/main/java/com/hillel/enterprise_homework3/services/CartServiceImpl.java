package com.hillel.enterprise_homework3.services;

import com.hillel.enterprise_homework3.exceptions.NotFoundException;
import com.hillel.enterprise_homework3.models.CartModel;
import com.hillel.enterprise_homework3.repositories.CartRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductService productService;

    private final PersonService personService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService, PersonService personService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public void createCart(@NonNull Integer id) {
        CartModel cart = new CartModel(id);
        cartRepository.getCarts().put(cart.getCartId(), cart);
    }

    @Override
    public Collection<CartModel> getAllCartsByPersonId(@NonNull Integer id) {
        Collection<CartModel> carts = cartRepository.getCarts().values()
                .stream().filter(cartModel -> cartModel.getOwnerId().equals(id))
                .collect(Collectors.toList());
        return carts;

    }

    @Override
    public CartModel getCart(Integer id) throws NotFoundException {
        if (cartRepository.getCarts().containsKey(id)){
            return cartRepository.getCarts().get(id);
        } else {
            throw new NotFoundException(cartRepository, id);
        }
    }

    @Override
    public void addProductByProductIdAndCartId(@NonNull Integer productId, @NonNull Integer cartId)
            throws NotFoundException {

       if (cartRepository.getCarts().containsKey(cartId)) {
           CartModel cart = cartRepository.getCarts().get(cartId);

           cart.getProducts().add(productService.getProductById(productId));
           cart.setSum(cart.getSum().add(BigDecimal.valueOf(productService.getProductById(productId).getProductPrice())));
       } else {
           throw new NotFoundException(cartRepository, cartId);
       }
    }

    @Override
    public void removeProductByProductIdAndCartId(@NonNull Integer productId, @NonNull Integer cartId)
            throws NotFoundException {

        if (cartRepository.getCarts().containsKey(cartId)) {
            CartModel cart = cartRepository.getCarts().get(cartId);

            cart.getProducts().remove(productService.getProductById(productId));
            cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(productService.getProductById(productId).getProductPrice())));
        } else {
            throw new NotFoundException(cartRepository, cartId);
        }
    }

    @Override
    public void removeAllProductsByCartId(@NonNull Integer id) throws NotFoundException {
        if (cartRepository.getCarts().containsKey(id)) {
            cartRepository.getCarts().get(id).getProducts().clear();
        } else {
            throw new NotFoundException(cartRepository, id);
        }
    }

    @Override
    public void removeCartById(@NonNull Integer id) throws NotFoundException {
        if (cartRepository.getCarts().containsKey(id)) {
            cartRepository.getCarts().remove(id);
        } else {
            throw new NotFoundException(cartRepository, id);
        }
    }

    @Override
    public void removeAllCartsByPersonId(@NonNull Integer id) throws NotFoundException {
        personService.getPersonById(id).getCarts().clear();
    }
}
