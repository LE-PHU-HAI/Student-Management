let languageData = null;
let currentLanguage = localStorage.getItem('currentLanguage') || document.documentElement.lang; // Lưu trữ ngôn ngữ hiện tại, mặc định là ngôn ngữ của trình duyệt

// Lấy dữ liệu từ tệp JSON khi trang được tải
fetch('/js/lang.json')
  .then(response => response.json())
  .then(data => {
    languageData = data;
    applyLanguageData(currentLanguage); // Áp dụng dữ liệu ngôn ngữ khi trang được tải
  })
  .catch(error => console.error('Error:', error));

// Thêm sự kiện click cho các nút chuyển đổi ngôn ngữ
document.getElementById('btn-lang-en').addEventListener('click', function() {
  changeLanguage('en');
});

document.getElementById('btn-lang-ja').addEventListener('click', function() {
  changeLanguage('ja');
});

// Hàm thay đổi ngôn ngữ và cập nhật giao diện người dùng
function changeLanguage(lang) {
  applyLanguageData(lang); // Áp dụng dữ liệu ngôn ngữ mới
  localStorage.setItem('currentLanguage', lang); // Lưu trạng thái ngôn ngữ vào localStorage
}

// Áp dụng dữ liệu ngôn ngữ cho giao diện người dùng
function applyLanguageData(lang) {
  if (languageData && languageData[lang]) { // Kiểm tra xem dữ liệu ngôn ngữ đã được tải và có ngôn ngữ cần áp dụng hay không
    const elements = document.querySelectorAll('[data-lang]');
    elements.forEach(element => {
      const key = element.getAttribute('data-lang');
      if (languageData[lang][key]) {
        // Kiểm tra nếu phần tử là input và có thuộc tính placeholder
        if (element.tagName.toLowerCase() === 'input' && element.hasAttribute('placeholder')) {
          element.setAttribute('placeholder', languageData[lang][key]);
        } else {
          element.innerText = languageData[lang][key];
        }
      }
    });
  }
}

// Hàm cập nhật sự kiện click cho các nút chuyển đổi ngôn ngữ
function updateLanguageButtonsEventListeners() {
  document.getElementById('btn-lang-en').addEventListener('click', function() {
    changeLanguage('en');
  });

  document.getElementById('btn-lang-ja').addEventListener('click', function() {
    changeLanguage('ja');
  });
}

// Gọi hàm cập nhật sự kiện sau mỗi lần nội dung được tải lại
updateLanguageButtonsEventListeners();



 function submitForm() {
        document.getElementById("searchForm").submit();
    }

    // Xử lý xác nhận xóa sinh viên
    var btnDeleteList = document.querySelectorAll('.btn-delete');

    btnDeleteList.forEach(function(btnDelete) {
        btnDelete.addEventListener('click', function(event) {
            var userConfirmed = false;
             swal({
                  title: languageData[currentLanguage].delete_confirmation_title,
                  icon: "warning",
                  buttons: {
                    cancel: languageData[currentLanguage].cancel_button,
                    ok: languageData[currentLanguage].ok_button
                  },
                  dangerMode: true,
            })
            .then((userConfirmation) => {
                userConfirmed = userConfirmation;

                if (userConfirmed) {
                    var studentId = this.getAttribute('href').match(/\/students\/(\d+)/)[1];
                    window.location.href = '/students/delete/' + studentId;
                } else {
                    event.preventDefault();
                }
            });

            if (!userConfirmed) {
                event.preventDefault();
            }
        });
    });
