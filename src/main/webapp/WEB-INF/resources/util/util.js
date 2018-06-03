var Request = function (type, endpoint, data) {
    return {
        method: type,
        url: $(location).attr('origin') + endpoint,
        headers: {
            'Content-Type': 'application/json'
        },
        data: data
    }
};
