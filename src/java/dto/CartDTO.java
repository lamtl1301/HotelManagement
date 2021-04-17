    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class CartDTO {

    private HashMap<Integer, RoomDTO> cart;

    public CartDTO() {
    }

    public CartDTO(HashMap<Integer, RoomDTO> cart) {
        this.cart = cart;
    }

    public HashMap<Integer, RoomDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<Integer, RoomDTO> cart) {
        this.cart = cart;
    }

    public void add(RoomDTO dto) {
        if (cart == null) {
            this.cart = new HashMap<>();
        }
        cart.put(dto.getRoomID(), dto);
    }

    public void delete(int id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

}
