var Component = {
    TAB_1 : 'resources/car/car-list.html',
    TAB_2 : 'resources/desktop/test2.html',
    TAB_3 : 'resources/desktop/test3.html',
    REGISTER_BUTTON : 'resources/customer/account/register/account-register.html',
    SUCCESS_REGISTER_INFO: 'resources/info/register_success.html',
    SUCCESS_RENT_CAR_INFO: 'resources/info/rent_car_success.html',
    RENT_CAR_FORM: 'resources/car/car-rent-form.html'
};

var Action = {
    LOAD_CONTENT : 'LOAD_CONTENT'
};

var ReqType = {
    GET : 'GET',
    POST : 'POST',
    PUT : 'PUT',
    DELETE : 'DELETE'
};

var ReqEndpoint = {
    GET_CAR_LIST : '/cars',
    GET_SESSION_CUSTOMER : '/authentication/customer',
    REGISTER_ACCOUNT : '/customers',
    RENT_CAR : '/cars/rent/',
    FIND_CUSTOMER : '/customers/find',
    AUTHENTICATION: '/authentication/login'
};