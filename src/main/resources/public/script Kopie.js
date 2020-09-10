const URL = 'http://localhost:8081';
let entries = [];
let projects = [];
let categories = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};

const createEntry = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entry = {};
    entry['checkIn'] = dateAndTimeToDate(formData.get('checkInDate'), formData.get('checkInTime'));
    entry['checkOut'] = dateAndTimeToDate(formData.get('checkOutDate'), formData.get('checkOutTime'));

    fetch(`${URL}/entries`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(entry)
    }).then((result) => {
        result.json().then((entry) => {
            entries.push(entry);
            renderEntries();
        });
    });
};

const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(new Date(entry.checkIn).toLocaleString()));
        row.appendChild(createCell(new Date(entry.checkOut).toLocaleString()));
        display.appendChild(row);
    });
};

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createEntryForm');
    createEntryForm.addEventListener('submit', createEntry);
    indexEntries();
});

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createProjectForm');
    createEntryForm.addEventListener('submit', createProject);
    indexProjects();
});

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createCategoryForm');
    createEntryForm.addEventListener('submit', createCategory);
    indexCategories();
});

document.addEventListener('DOMContentLoaded', function(){
    const createEntryForm = document.querySelector('#createLoginForm');
    createEntryForm.addEventListener('submit', createLogin);
    
});

// Project
const createProject = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const project = {};
    project['name'] = formData.get('name')
   

    fetch(`${URL}/project`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(project)
    }).then((result) => {
        result.json().then((project) => {
            entries.push(project);
            renderProjects();
        });
    });
};

const renderProjects = () => {
    const display = document.querySelector('#projectDisplay');
    display.innerHTML = '';
    projects.forEach((project) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(project.id));
        row.appendChild(createCell(project.name);
        display.appendChild(row);
    });
};

const indexProjects = () => {
    fetch(`${URL}/projects`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            projects = result;
            renderProjects();
        });
    });
    renderProjects();
};

// Category
const createCategory = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const category = {};
    category['name'] = formData.get('name')
   

    fetch(`${URL}/category`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(category)
    }).then((result) => {
        result.json().then((category) => {
            entries.push(category);
            renderCategories();
        });
    });
};

const renderCategories = () => {
    const display = document.querySelector('#categoryDisplay');
    display.innerHTML = '';
    categories.forEach((category) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(category.id));
        row.appendChild(createCell(category.name);
        display.appendChild(row);
    });
};

const indexCategories = () => {
    fetch(`${URL}/category`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            categories = result;
            renderCategories();
        });
    });
    renderCategories();
};