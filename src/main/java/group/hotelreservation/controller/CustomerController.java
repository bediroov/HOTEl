package group.hotelreservation.controller;
import group.hotelreservation.dto.customer.request.CustomerRequest;
import group.hotelreservation.dto.customer.response.CustomerResponse;
import group.hotelreservation.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public CustomerResponse saveAllCustomers(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.addCustomerwithReservation(customerRequest);
    }


    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // bu get pathvariable ucun
    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerResponse putCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable Long customerId) {
        return customerService.updateCustomer(customerRequest, customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
    }


}
