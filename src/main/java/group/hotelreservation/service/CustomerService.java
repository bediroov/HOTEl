package group.hotelreservation.service;
import group.hotelreservation.dao.repository.CustomerRepository;
import group.hotelreservation.dto.customer.request.CustomerRequest;
import group.hotelreservation.dto.customer.response.CustomerResponse;
import group.hotelreservation.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    public CustomerResponse addCustomerwithReservation(CustomerRequest customerRequest) {
        var customerEntity = customerMapper.mapToEntity(customerRequest);

        if (customerEntity.getReservations() != null) {
            customerEntity.getReservations().forEach(reservation -> reservation.setCustomer(customerEntity));

        }
        customerRepository.save(customerEntity);
        var response = customerMapper.mapToResponse(customerEntity);
        System.out.println("response:" + response);
        return response;

    }

    public List<CustomerResponse> getAllCustomers() {
        var customerEntitylist = customerRepository.findAll();
        return customerEntitylist.stream().map(customerMapper::mapToResponse).collect(Collectors.toList());
    }


    public CustomerResponse getCustomerById(Long customerId) {
        var customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("customer not found"));
        return customerMapper.mapToResponse(customerEntity);
    }


    public CustomerResponse updateCustomer(CustomerRequest customerRequest, Long customerId) {
        var existCustomer = customerRepository.findById(customerId).orElseThrow(() ->
                new RuntimeException("Customer not found!!!"));


        existCustomer.setName(customerRequest.getName());
        existCustomer.setSurname(customerRequest.getSurname());
        existCustomer.setAge(customerRequest.getAge());
        existCustomer.setEmail(customerRequest.getEmail());
        existCustomer.setPhonenumber(customerRequest.getPhonenumber());

        customerRepository.save(existCustomer);
        return customerMapper.mapToResponse(existCustomer);

    }



    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }


}
