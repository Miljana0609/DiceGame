document.addEventListener('DOMContentLoaded', () => {
    const rollBtn = document.getElementById('rollBtn');
    const resetBtn = document.getElementById('resetBtn');
    const resText = document.getElementById('resultText');

    function prepareDice(el) {
        el.innerHTML = '';
        const pips = document.createElement('div');
        pips.className = 'pips';
        for (let i = 0; i < 9; i++) {
            const pip = document.createElement('div');
            pip.className = 'pip';
            pips.appendChild(pip);
        }
        el.appendChild(pips);
    }

    const mapping = {
        1: [4],
        2: [0, 8],
        3: [0, 4, 8],
        4: [0, 2, 6, 8],
        5: [0, 2, 4, 6, 8],
        6: [0, 2, 3, 5, 6, 8]
    };

    const diceEls = [
        document.getElementById('p1-d1'),
        document.getElementById('p1-d2'),
        document.getElementById('p2-d1'),
        document.getElementById('p2-d2'),
    ];
    diceEls.forEach(prepareDice);

    function showNumberOnDice(el, n) {
        const pips = el.querySelectorAll('.pip');
        pips.forEach(p => p.classList.remove('on'));
        (mapping[n] || []).forEach(idx => pips[idx].classList.add('on'));
    }

    function rand6() {
        return Math.floor(Math.random() * 6) + 1;
    }

    rollBtn.addEventListener('click', async () => {
        const p1Name = (document.getElementById('p1-first').value + ' ' +
            document.getElementById('p1-last').value).trim() || 'Spelare 1';
        const p2Name = (document.getElementById('p2-first').value + ' ' +
            document.getElementById('p2-last').value).trim() || 'Spelare 2';

        diceEls.forEach(d => d.classList.add('rolling'));
        resText.textContent = 'Kastar...';
        rollBtn.disabled = true;

        await new Promise(r => setTimeout(r, 400));

        const p1a = rand6(), p1b = rand6();
        const p2a = rand6(), p2b = rand6();

        showNumberOnDice(diceEls[0], p1a);
        showNumberOnDice(diceEls[1], p1b);
        showNumberOnDice(diceEls[2], p2a);
        showNumberOnDice(diceEls[3], p2b);

        const s1 = p1a + p1b;
        const s2 = p2a + p2b;
        document.getElementById('p1-sum').textContent = s1;
        document.getElementById('p2-sum').textContent = s2;


        diceEls.forEach(d => d.classList.remove('rolling'));
        rollBtn.disabled = false;

        let msg;
        if (s1 > s2) msg = `${p1Name} vinner! (${s1} vs ${s2})`;
        else if (s2 > s1) msg = `${p2Name} vinner! (${s2} vs ${s1})`;
        else msg = `Oavgjort! (${s1} vs ${s2})`;

        resText.textContent = msg;
    });

    resetBtn.addEventListener('click', () => {
        diceEls.forEach(d => {
            d.querySelectorAll('pip').forEach(p => p.classList.remove('on'));
        });
        document.getElementById('p1-sum').textContent = '-';
        document.getElementById('p2-sum').textContent = '-';
        resText.textContent = 'Tryck "Kasta tärningar" för att börja';
        document.getElementById('p1-first').value = '';
        document.getElementById('p1-last').value = '';
        document.getElementById('p2-first').value = '';
        document.getElementById('p1-last').value = '';
    });
});