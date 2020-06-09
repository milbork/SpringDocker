package pl.xyz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    ItemRepo itemRepo;

    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping("/getitem/{id}")
    @ResponseBody
    public String getItemById(@PathVariable Long id){
        System.out.println(id);
        Item item = itemRepo.findById(id).orElseThrow(RuntimeException::new);
        return item.description;
    }

}
