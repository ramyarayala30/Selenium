function contact() {
    const email = document.getElementById('exampleFormControlInput1');
    const message = document.getElementById('exampleFormControlTextarea1');

    const pattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$/;
    if (pattern.test(email.value)) {
        alert('Enter a valid email address');
        return;
    }

    if(message.value.length < 10) {
        alert('Message should be at least 10 characters long');
        return;
    }

    console.log('Email: ' + email.value);
    console.log('Message: ' + message.value);
    alert('Thank you for contacting us! We will get back to you soon.');
    email.value = '';
    message.value = '';
}