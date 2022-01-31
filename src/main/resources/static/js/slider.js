
window.addEventListener('DOMContentLoaded', () => {
    'use strict';
    slider()
});

const slider = () => {
    const news = document.querySelectorAll('.news_full_description')
    news.forEach((item) => {
        let slideIndex = 1;
        item.addEventListener('click', function (e) {
            if (e.target.classList == "next" || e.target.classList == "prev") {
                const slides = [],
                    target_slider = e.path[1];
                target_slider.childNodes.forEach(element => {
                    if (element.classList == 'active' || element.classList == 'none') {
                        slides.push(element)
                    }
                })

                if (e.target.classList == "next") {
                    plusSlides(1);
                    slides.forEach((item) => {
                        item.style.display = "none";
                    })
                    slides[slideIndex - 1].style.display = "block";
                }

                if (e.target.classList == "prev") {
                    plusSlides(-1);
                    slides.forEach((item) => {
                        item.style.display = "none";
                    })
                    slides[slideIndex - 1].style.display = "block";
                }

                function showSlides(n) {
                    if (n > slides.length) {
                        slideIndex = 1;
                    }
                    if (n < 1) {
                        slideIndex = slides.length;
                    }
                }

                function plusSlides(n) {
                    showSlides(slideIndex += n);
                }
            }
        })
    })
}
