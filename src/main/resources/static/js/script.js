let languageData = null;
let currentLanguage = document.documentElement.lang; // Lưu trữ ngôn ngữ hiện tại

// Lấy dữ liệu từ tệp JSON khi trang được tải
fetch('./js/lang.json')
  .then(response => response.json())
  .then(data => {
    languageData = data;
    applyLanguageData(currentLanguage); // Áp dụng dữ liệu ngôn ngữ khi trang được tải
  })
  .catch(error => console.error('Error:', error));

// Áp dụng dữ liệu ngôn ngữ cho giao diện người dùng
function applyLanguageData(lang) {
  if (languageData) { // Kiểm tra xem dữ liệu ngôn ngữ đã được tải hay chưa
    const elements = document.querySelectorAll('[data-lang]');
    elements.forEach(element => {
      const key = element.getAttribute('data-lang');
      if (languageData[lang] && languageData[lang][key]) {
        element.innerText = languageData[lang][key];
      }
    });
  }
}

// Kiểm tra nếu đã lưu trạng thái ngôn ngữ trước đó trong local storage
document.addEventListener('DOMContentLoaded', function() {
  var storedLanguage = localStorage.getItem('currentLanguage');
  if (storedLanguage) {
    currentLanguage = storedLanguage;
    applyLanguageData(currentLanguage);
  }
});

// Thêm sự kiện click cho nút chuyển đổi ngôn ngữ tiếng Anh
document.getElementById('btn-lang-en').addEventListener('click', function() {
  changeLanguage('en');
});

// Thêm sự kiện click cho nút chuyển đổi ngôn ngữ tiếng Nhật
document.getElementById('btn-lang-ja').addEventListener('click', function() {
  changeLanguage('ja');
});

// Hàm thay đổi ngôn ngữ và cập nhật giao diện người dùng
function changeLanguage(lang) {
  applyLanguageData(lang); // Áp dụng dữ liệu ngôn ngữ mới
  localStorage.setItem('currentLanguage', lang); // Lưu trạng thái ngôn ngữ
}
